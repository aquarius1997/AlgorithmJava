package DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_카카오프렌즈컬러링북2 {
    int[][] visited;
    int maxCnt = 0;

    public void travelingArea(int[][] picture, int color, int row, int col, int m, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int areaCnt = 0;    //구역의 크기를 저장한다
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        queue.add(row);
        queue.add(col);
        visited[row][col] = 1;

        int r, c;
        while(!queue.isEmpty()) {
            r = queue.poll();
            c = queue.poll();
            areaCnt++;

            for(int i=0; i<4; i++) {
                if(r+dx[i] >= 0 && r+dx[i] < m && c+dy[i] >= 0 && c+dy[i] < n) {
                    if(picture[r+dx[i]][c+dy[i]] == color && visited[r+dx[i]][c+dy[i]] == 0) {
                        visited[r+dx[i]][c+dy[i]] = 1;
                        queue.add(r+dx[i]);
                        queue.add(c+dy[i]);
                    }
                }
            }
        }

        if(areaCnt > maxCnt) {
            maxCnt = areaCnt;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new int[m][n];    //방문하면 1로 저장

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(picture[i][j] != 0 && visited[i][j] == 0) {
                    travelingArea(picture, picture[i][j], i, j, m, n);
                    numberOfArea++;
                }
            }
        }

        maxSizeOfOneArea = maxCnt;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
