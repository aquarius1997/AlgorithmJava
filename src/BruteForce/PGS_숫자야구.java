package BruteForce;
import java.util.*;

/**
 * 중 복 숫 자 없 는 거 처 음 부 터 문 제 조 건 에 써 달 라 고
 */
public class PGS_숫자야구 {
    public int solution(int[][] baseball) {
        int answer = 0;
        List<Integer> numberList = new LinkedList<>();

        //초기화
        int num = 0;
        for(int i=1; i<=9; i++) {
            for(int j=1; j<=9; j++) {
                for(int k=1; k<=9; k++) {
                    if(i == j || i == k || j == k) {
                        continue;
                    }
                    num = (i * 100) + (j * 10) + k;
                    numberList.add(num);
                }
            }
        }

        int userNum = 0;    int strikeCnt = 0;  int ballCnt = 0;
        int strike = 0; int ball = 0;
        int idx = 0;
        int[] uflag = new int[3];    //스트라이크 -> 볼 순으로 확인된 자릿수는 1로 변경
        int[] flag = new int[3];
        //만들 수 없는 숫자일 경우 numberList에서 제거한다
        for(int i=0; i<baseball.length; i++) {
            userNum = baseball[i][0];
            strikeCnt = baseball[i][1];
            ballCnt = baseball[i][2];

            idx = 0;
            while(true) {
                if(idx >= numberList.size()) break;

                //초기화
                num = numberList.get(idx);
                strike = ball = 0;
                int uN1, uN2, uN3;
                int N1, N2, N3;
                uN1 = userNum / 100;    uN2 = (userNum%100) / 10;   uN3 = userNum%10;
                N1 = num / 100; N2 = (num%100) / 10;    N3 = num%10;
                for(int j=0; j<3; j++) {
                    flag[j] = uflag[j] = 0;
                }

                //스트라이크 수 확인한다
                if(uN1 == N1){
                    uflag[0] = flag[0] = 1;    strike++;
                }
                if(uN2 == N2) {
                    uflag[1] = flag[1] = 1;    strike++;
                }
                if(uN3 == N3) {
                    uflag[2] = flag[2] = 1;    strike++;
                }

                //볼 개수 확인
                if(uflag[0] == 0) {
                    if(uN1 == N2 && flag[1] == 0) {
                        uflag[0] = flag[1] = 1;
                        ball++;
                    } else if(uN1 == N3 && flag[2] == 0) {
                        uflag[0] = flag[2] = 1;
                        ball++;
                    }
                }
                if(uflag[1] == 0) {
                    if(uN2 == N1 && flag[0] == 0) {
                        uflag[1] = flag[0] = 1;
                        ball++;
                    } else if(uN2 == N3 && flag[2] == 0) {
                        uflag[1] = flag[2] = 1;
                        ball++;
                    }
                }
                if(uflag[2] == 0) {
                    if(uN3 == N1 && flag[0] == 0) {
                        uflag[2] = flag[0] = 1;
                        ball++;
                    } else if(uN3 == N2 && flag[1] == 0) {
                        uflag[2] = flag[1] = 1;
                        ball++;
                    }
                }

                //가능한 답인지 확인
                if(strikeCnt != strike || ballCnt != ball) {
                    numberList.remove(idx);
                } else {
                    System.out.println(userNum + ", " + num);
                    idx++;
                }
            }
        }



        answer = numberList.size();


        return answer;
    }
}
