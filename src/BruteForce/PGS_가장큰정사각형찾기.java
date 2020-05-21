package BruteForce;


import java.util.ArrayList;

public class PGS_가장큰정사각형찾기 {

    public static int solution(int [][]board) {
        int answer = 0;
        int n = 0;  int temp = 0;
        int k = 0;
        int[][] horizon = new int[board.length][board[0].length];   //가로로 연속되는 1의 개수를 저장
        int cnt = 0;

        //가로로 연속되는 1의 개수를 구한다
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(j == 0) {
                    if(board[i][j] == 1) { horizon[i][j] = 1; }
                } else {
                    if(board[i][j] == 1) {
                        horizon[i][j] = horizon[i][j-1] + 1;
                    }
                }
            }
        }


        //아래로 내려가면서 정사각형 만들 수 있으면 한 변의 최대 길이로 업데이트한다
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(horizon[i][j] > n) {    //현재까지 구한 가장 긴 한변의 길이보다 값이 더 클 경우 확인한다
                    temp = horizon[i][j];   //temp : 정사각형 한 변의 길이
                    if(temp == 1) { if(temp > n) { n = temp; continue;}}
                    cnt = 1;    //값을 확인한 개수
                    if(i + temp - 1 >= board.length) { temp = board.length - i; }       //*****이거추가안하면 효율성 테스트 하나 통과 못함
                    while(temp > n) {
                        if(i+cnt < board.length) {  //범위 이내에서만 확인
                            if(horizon[i+cnt][j] < temp) {  //정사각형 한 변의 길이를 줄여야 할 경우
                                temp = horizon[i+cnt][j];
                            }
                            cnt++;
                            if(cnt == temp) {   //만들려는 정사각형을 다 만들면 최대 변의 길이 업데이트하고 break
                                if(n < temp) { n = temp; }
                                break;
                            }
                        } else { break; }
                    }   //end while
                }
            }
        }

        answer = n * n;

        return answer;
    }

    public static void main(String[] args) {
        int [][]board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
        int answer = solution(board);
        System.out.println(answer);
    }
}
