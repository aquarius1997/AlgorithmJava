package DivideAndConquer;

import java.util.*;

public class No1780_종이의개수 {
    static int[][] T = new int[2500][2500];
    static int zeroCnt;
    static int minusCnt;
    static int plusCnt;

    No1780_종이의개수() {
        Arrays.fill(T, 0);
        zeroCnt = 0;
        minusCnt = 0;
        plusCnt = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        N = scanner.nextInt();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int number = scanner.nextInt();
                T[i][j] = number;
            }
        }

        numOfPaper(0, N-1, 0, N-1);

        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.println(plusCnt);
    }

    /**
     * [r1,c1] ~ [r2, c2] 범위의 종이가 모두 같은 숫자인지 검증하여 아닐경우 분할정복한다
     * @param r1 시작 행
     * @param r2 마지막 행
     * @param c1 시작 열
     * @param c2 마지막 열
     */
    public static void numOfPaper(int r1, int r2, int c1, int c2) {
        int num;
        int div;
        int flag = 0;

        num = T[r1][c1];

        for(int i=r1; i<=r2; i++) {
            for(int j=c1; j<=c2; j++) {
                if(T[i][j] != num) {    //다 같은 숫자로 채워져 있지 않을 경우
                    flag = 1;   break;
                }
            }
            if(flag == 1) {
                break;
            }   //end for(j)
        }   //end for(i)

        if(flag == 1) { //분할정복
            div = (r2 - r1 + 1) / 3;
            numOfPaper(r1, r1+div-1, c1, c1+div-1);
            numOfPaper(r1, r1+div-1, c1+div, c1+(2*div)-1);
            numOfPaper(r1, r1+div-1, c1+2*div, c1+(3*div)-1);
            numOfPaper(r1+div, r1+(2*div)-1, c1, c1+div-1);
            numOfPaper(r1+div, r1+(2*div)-1, c1+div, c1+(2*div)-1);
            numOfPaper(r1+div, r1+(2*div)-1, c1+2*div, c1+(3*div)-1);
            numOfPaper(r1+2*div, r1+(3*div)-1, c1, c1+div-1);
            numOfPaper(r1+2*div, r1+(3*div)-1, c1+div, c1+(2*div)-1);
            numOfPaper(r1+2*div, r1+(3*div)-1, c1+2*div, c1+(3*div)-1);
        } else {    //같은 숫자
            if(num == 1) {
                plusCnt++;
            } else if(num == 0) {
                zeroCnt++;
            } else {
                minusCnt++;
            }
        }
    }
}
