package SamSung;

import java.util.*;

public class No15684_사다리조작 {
    static int[][] table;
    static int N, H, M;
    static int flag;
    static int answer;

    /**
     * num개의 사다리를 추가하고, 조건을 만족하는지 확인한다. 조건을 만족할 경우 필드 변수 flag를 1로 변경한다
     * @param num 추가해야하는 사다리의 수
     * @param num_cnt 현재까지 추가한 사다리 개수
     * @param row 사다리를 놓을 기준 행
     * @param col 사다리를 놓을 기준 열
     */
    public static void making_ladder(int num, int num_cnt, int row, int col) {
        //사다리를 놓는다
        if(num != 0) {
            table[row][col] = 1;    table[row][col+1] = 2;
        }
        //num개의 사다리를 추가했으면 조건을 확인한다
        if(num == num_cnt) {
            int is_ok = 0;  //조건을 만족하는지 확인하는 변수 ( 만족 : 0 )
            int c;  //사다리를 다 타고 내려왔을 때 어느 세로선에 있는지를 알아낼 변수
            for(int j=1; j<=N; j++) {   //모든 사다리에 대해
                c = j;
                for(int i=1; i<=H; i++) {   //사다리를 타고 내려온다
                    if(table[i][c] == 1) {  //오른쪽으로 이동해야할 경우
                        c = c+1;    continue;
                    }
                    if(table[i][c] == 2) {  //왼쪽으로 이동해야할 경우
                        c = c-1;    continue;
                    }
                }
                if(c != j) {    //원래 세로선으로 끝나지 않을 경우
                    is_ok = 1;  break;
                }
            }
            if(is_ok == 0) {    //모든 세로선이 원래의 위치로 끝나면 (조건만족)
                flag = 1;
            }
        } else {    //아직 num개의 사다리를 다 추가하지 않았으면
            for(int j=col+1; j<=N; j++) {
                if(table[row][j] == 0 && j+1 <= N) {
                    if(table[row][j+1] == 0) {
                        making_ladder(num, num_cnt+1,row, j);
                    }
                }
            }
            for(int i=row+1; i<=H; i++) {
                for(int j=0; j<=N; j++) {
                    if(table[i][j] == 0 && j+1 <= N) {
                        if(table[i][j+1] == 0) {
                            making_ladder(num, num_cnt+1, i, j);
                        }
                    }
                }
            }
        }
        //초기화
        if(num != 0) {
            table[row][col] = 0;    table[row][col+1] = 0;
        }
    }


    /**
     * num개의 사다리를 추가해서 조건을 만족하는지 확인한다
     * @param num 추가하려는 사다리의 개수
     */
    public static void simulation (int num) {
        int flag2 = 0;  // 0 : 사다리를 놓을 수 없는 경우
        if(num > 3) return; //3개보다 많이 추가해야 할 경우 종료

        if(num == 0) {  //기본 가로선으로 이동가능한 경우를 확인한다
            making_ladder(0, 0, 1, 1);
            if(flag == 1) { answer = num; }
            flag2 = 1;
        } else {    //num개의 사다리를 추가하는 함수를 호출한다
            for(int i=1; i<=H; i++) {
                for (int j = 1; j <= N; j++) {
                    if (table[i][j] == 0 && j+1 <= N) {
                        if (table[i][j+1] == 0) {    //사다리를 놓을 수 있는 경우
                            flag2 = 1;
                            making_ladder(num, 1, i, j);
                            if (flag == 1) { //num개의 사다리로 조건 만족
                                answer = num;
                                break;
                            }
                        }
                    }
                }
                if(flag == 1) { break; }
            }
        }

        if(flag2 == 0) {    //사다리 놓는 함수를 호출하지 못한 경우 그 다음 경우는 알아볼 필요도 없다
            return;
        }
        if(flag == 0) { //아직 조건을 만족 못한 경우 사다리를 1개 더 추가한다
            simulation(num+1);
        }
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        table = new int[32][12];
        int a, b;
        flag = 0;
        answer = -1;

        N = scanner.nextInt();  M = scanner.nextInt();  H = scanner.nextInt();

        for(int i=1; i<=M; i++) {   //기본 가로선 입력 받아 저장
            a = scanner.nextInt();
            b = scanner.nextInt();
            table[a][b] = 1;    //R(오른쪽으로 이동해야 함을 의미)
            table[a][b+1] = 2;  //L(왼쪽으로 이동해야 함을 의미)
        }

        //사다리 놓는 함수 호출
        simulation(0);

        System.out.print(answer);
    }
}
