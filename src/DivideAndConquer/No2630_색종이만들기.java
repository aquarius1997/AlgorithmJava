package DivideAndConquer;
import java.util.*;

public class No2630_색종이만들기 {
    static int T[][] = new int[129][129];
    static int blueCnt;
    static int whiteCnt;

    No2630_색종이만들기() {   //생성자로 값 초기화
        Arrays.fill(T, 0);
        blueCnt = 0;
        whiteCnt = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        N = scanner.nextInt();

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                int num = scanner.nextInt();
                T[i][j] = num;
            }
        }

        divide_conquer(1, N, 1, N);

        System.out.println(whiteCnt);
        System.out.print(blueCnt);
    }

    /**
     * 구역[행(s1~e1) 열(s2~e2)] 에 대하여 모두 같은 색으로 칠해져 있는지 확인한다. 같은색이 아닐 경우 분할, 같은색일 경우 카운트
     * @param s1 모두 같은 색인지 검사할 행의 시작 인덱스
     * @param e1 모두 같은 색인지 검사할 행의 마지막 인덱스
     * @param s2 모두 같은 색인지 검사할 열의 시작 인덱스
     * @param e2 모두 같은 색인지 검사할 열의 마지막 인덱스
     */
    public static void divide_conquer(int s1, int e1, int s2, int e2) {
        int rowMid, colMid;
        int bOrW = 0;
        int color;

        if(s1 == e1) {
            color = T[s1][s2];
            if(color == 0) {
                whiteCnt++;
            } else {
                blueCnt++;
            }
        } else {
            color = T[s1][s2];
            for(int i=s1; i<=e1; i++) {
                for(int j=s2; j<=e2; j++) {
                    if(T[i][j] != color) {
                        bOrW = -1;  break;
                    }
                }
                if(bOrW == -1) {
                    break;
                }
            }

            if(bOrW != -1) {    //모두 같은 색일 경우
                if(color == 0) {    //흰색일 경우
                    whiteCnt++;
                } else {
                    blueCnt++;
                }
            } else {    //모두 같은 색이 아닐 경우 분할
                //가운데가 어딘지 알아내고
                rowMid = (s1 + e1) / 2;
                colMid = (s2 + e2) / 2;
                //네개로 분할정복
                divide_conquer(s1, rowMid, s2, colMid);
                divide_conquer(s1, rowMid, colMid+1, e2);
                divide_conquer(rowMid+1, e1, s2, colMid);
                divide_conquer(rowMid+1, e1, colMid+1,e2);
            }
        }
    }

}
