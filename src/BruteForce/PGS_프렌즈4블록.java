package BruteForce;

/**
 * 26min 0Fail
 */
public class PGS_프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int i, j;

        char friends;
        int[][] erase = new int[m][n];
        char[][] boardC = new char[m][n];
        int eraseFlag = 0;

        for(i=0; i<m; i++) {
            for(j=0; j<n; j++) {
                boardC[i][j] = board[i].charAt(j);
            }
        }

        while(true) {
            //1. 지울 프렌즈를 알아낸다
            for(i=0; i<m-1; i++) {
                for(j=0; j<n-1; j++) {
                    friends = boardC[i][j];   //기준 프렌즈
                    if(boardC[i][j] == 'x') { continue; }
                    //4*4 만족하는지 확인
                    if((boardC[i][j+1] == friends) && (boardC[i+1][j] == friends) && (boardC[i+1][j+1] == friends)) {
                        erase[i][j] = erase[i][j+1] = erase[i+1][j] = erase[i+1][j+1] = 1;
                    }
                }
            }

            //2. 프렌즈를 지운다
            eraseFlag = 0;
            for(i=0; i<m; i++) {
                for(j=0; j<n; j++) {
                    if(erase[i][j] == 1) {
                        answer++;
                        erase[i][j] = 0;
                        eraseFlag = 1;
                        boardC[i][j] = 'x';
                    }
                }
            }

            if(eraseFlag == 0) {    //지워진 프렌즈가 없으면
                break;
            }

            int k = 0;
            int cnt = 0;
            //3. 빈 공간을 없앤다
            for(j=0; j<n; j++) {
                for(i=m-1; i>=0; i--) {
                    if(boardC[i][j] == 'x') { //지워ㅣㅈㄴ곳이면
                        cnt = 1;
                        for(k=i-1; k>=0; k--) {
                            if(boardC[k][j] == 'x') { //빈공간이면
                                cnt++;
                            } else {
                                boardC[k+cnt][j] = boardC[k][j];
                                boardC[k][j] = 'x';
                                break;
                            }
                        }
                    }
                }
            }

        }

        return answer;
    }
}
