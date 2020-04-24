package DFSandBFS;
import java.util.*;

public class PGS_카카오프렌즈컬러링북 {
    int[][] visited;
    int maxNum = 0;
    int cnt = 0;

    public void bfs_searching(int row, int col, int m, int n, int[][] picture) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int number = picture[row][col];
        int r, c;

        //큐에 입력으로 들어온 위치 삽입
        visited[row][col] = 1;
        arrayList.add(row);
        arrayList.add(col);

        //큐가 빌때까지 반복
        while(!arrayList.isEmpty()) {
            r = arrayList.get(0);
            arrayList.remove(0);
            c = arrayList.get(0);
            arrayList.remove(0);
            cnt++;

            if(r-1 >= 0) {
                if(visited[r-1][c] == 0 && picture[r-1][c] == number) {
                    visited[r-1][c] = 1;
                    arrayList.add(r-1);
                    arrayList.add(c);
                }
            }
            if(r+1 < m) {
                if(visited[r+1][c] == 0 && picture[r+1][c] == number) {
                    visited[r+1][c] = 1;
                    arrayList.add(r+1);
                    arrayList.add(c);
                }
            }
            if(c-1 >= 0) {
                if(visited[r][c-1] == 0 && picture[r][c-1] == number) {
                    visited[r][c-1] = 1;
                    arrayList.add(r);
                    arrayList.add(c-1);
                }
            }
            if(c+1 < n) {
                if(visited[r][c+1] == 0 && picture[r][c+1] == number) {
                    visited[r][c+1] = 1;
                    arrayList.add(r);
                    arrayList.add(c+1);
                }
            }
        }
        //end while

        //최대갯수 업데이t
        if(cnt > maxNum) {
            maxNum = cnt;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        visited = new int[m][n];
   //     Arrays.fill(visited, 0);

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //방문안한 곳은
                if(picture[i][j] != 0 && visited[i][j] == 0){
                    bfs_searching(i, j, m , n, picture);
                    numberOfArea++;

                }
            }
        }

        maxSizeOfOneArea = maxNum;

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
