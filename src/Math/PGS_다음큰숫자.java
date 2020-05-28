package Math;

import java.util.ArrayList;

public class PGS_다음큰숫자 {
    public int solution(int n) {
        int answer = 0;
        ArrayList<Integer> binNum = new ArrayList<Integer>();
        int idx = 0;
        int j = 0;

        //n을 2진수로 변환
        while(n > 1) {
            binNum.add((n%2));
            n /= 2;
        }
        binNum.add(1);

        for(int i=0; i<binNum.size(); i++) {
            if(binNum.get(i) == 1) {
                idx = i;    break;
            }
        }
        while(true) {
            if(idx+1 < binNum.size()) {
                if(binNum.get(idx+1) == 1) {
                    idx += 1;
                } else { break; }
            } else { break; }
        }

        if(idx+1 < binNum.size()) {
            binNum.set(idx+1, 1);
            binNum.set(idx, 0);
        } else {
            binNum.add(0, 0);
        }

        System.out.println(idx);

        for(int i=0; i<=idx; i++) {
            if(binNum.get(i) == 1) {
                binNum.set(i, 0);
                for(j=i-1; j>=0; j--) {
                    if(binNum.get(j) == 1) {
                        binNum.set(j+1, 1);
                        break;
                    }
                }
                if(j == -1) {
                    binNum.set(0, 1);
                }
            }
        }

        int base = 1;
        for(int i=0; i<binNum.size(); i++) {
            answer += (base * binNum.get(i));
            base *= 2;
        }


        return answer;
    }
}
