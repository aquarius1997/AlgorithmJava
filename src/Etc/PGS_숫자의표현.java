package Etc;

import java.util.ArrayList;

public class PGS_숫자의표현 {
    public int solution(int n) {
        int answer = 0;
        int tempSum = 0;
        int diff = 0;
        ArrayList<Integer> sumArr = new ArrayList<Integer>();

        sumArr.add(0);

        //i가 3일 경우 숫자 1~3의 sum을 저장함
        for(int i=1; i<=n; i++) {
            tempSum = sumArr.get(i-1) + i;
            sumArr.add(tempSum);
        }

        int startIdx, endIdx;
        startIdx = endIdx = 0;

        //초기 : endIdx가 가르키는 값이 n보다 크거나 같을때까지로 이동한다
        while(true) {
            if(sumArr.get(endIdx) >= n) { break; }
            endIdx++;
        }

        while(endIdx < sumArr.size()) {
            diff = sumArr.get(endIdx) - n;  //n을 구하기 위해서 빼야할 값
            while(startIdx < endIdx) {
                if(diff == sumArr.get(startIdx)) {  //n값을 구할 수 있는 경우
                    answer++;   break;
                } else if(diff < sumArr.get(startIdx)) {    //endIdx이 마지막 숫자일 경우 n값을 구할수 없음.
                    break;
                } else {
                    startIdx++;
                }
            }
            endIdx++;
        }

        return answer;
    }
}
