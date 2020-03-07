package DivideAndConquer;
import java.util.*;

public class No1992_쿼드트리 {
    static int T[][] = new int[65][65];

    No1992_쿼드트리() {
        Arrays.fill(T, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;

        N = scanner.nextInt();

        for(int i=1; i<=N; i++) {
            String str = scanner.next();
            for(int j=1; j<=N; j++) {
                int num = str.charAt(j-1) - '0';
                T[i][j] = num;
            }
        }

        quad_tree(1, N, 1, N);
    }

    /**
     * 구역[행(s1~e1) 열(s2~e2)] 에 대하여 모두 같은 숫자인지 확인한다.
     * @param s1 모두 같은 숫자인지 검사할 행의 시작 인덱스
     * @param e1 모두 같은 숫자인지 검사할 행의 마지막 인덱스
     * @param s2 모두 같은 숫자인지 검사할 열의 시작 인덱스
     * @param e2 모두 같은 숫자인지 검사할 열의 마지막 인덱스
     * @return 모두 같은 숫자일 경우 해당 숫자(0 또는 1) 리턴. 섞여있을 경우 -1 리턴
     */
    public static int zero_or_one(int s1, int e1, int s2, int e2) {
        int zeroOrOne;

        zeroOrOne = T[s1][s2];

        //입력으로 받은 네모 구간이 모두 한 숫자인지 확인한다
        for(int i=s1; i<=e1; i++) {
            for(int j=s2; j<=e2; j++) {
                if(T[i][j] != zeroOrOne) {  //다른 숫자 섞여있으면
                    zeroOrOne = -1; break;
                }
            }
            if(zeroOrOne == -1) {
                break;
            }
        }

        return zeroOrOne;
    }

    /**
     * 구역[행(s1~e1) 열(s2~e2)] 에 대하여 (왼쪽상단 오른쪽상단 왼쪽하단 오른쪽하단)을 출력한다
     * @param s1 출력할 행의 시작 인덱스
     * @param e1 출력할 행의 마지막 인덱스
     * @param s2 출력할 열의 시작 인덱스
     * @param e2 출력할 열의 마지 인덱스
     */
    public static void quad_tree(int s1, int e1, int s2, int e2) {
        int midRow, midCol;
        int zeroOrOne;  //모두 0이면 0, 모두 1이면 1, 섞여있으면 -1

        if(zero_or_one(s1, e1, s2, e2) != -1) { //한 숫자로만 이뤄져있으면
            System.out.print(T[s1][s2]);
        } else {    //섞여있으면 네개의 구역으로나눠서 출력
            System.out.print("(");

            //모두 한 숫자로 표현할 수 있는지 확인한다
            zeroOrOne = zero_or_one(s1, e1, s2, e2);

            if(zeroOrOne == -1) {   //모두 한 숫자로 표현할 수 없을 경우 분할정복
                midRow = (s1 + e1) / 2;
                midCol = (s2 + e2) / 2;

                quad_tree(s1, midRow, s2, midCol);
                quad_tree(s1, midRow, midCol+1, e2);
                quad_tree(midRow+1, e1, s2, midCol);
                quad_tree(midRow+1, e1, midCol+1, e2);
            } else {   //모두 한 숫자인 경우 출력
                System.out.print(zeroOrOne);
            }

            System.out.print(")");
        }
    }
}
