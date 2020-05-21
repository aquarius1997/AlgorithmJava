package DFSandBFS;

/**
 * 10min 0Fail **
 */
public class PGS_네트워크 {
    int g_visit[] = {};

    public void dfs_visit(int n, int[][] computers, int node) {
        g_visit[node] = 1;
        for(int i=0; i<n; i++) {
            if(computers[node][i] == 1 && g_visit[i] == 0) {
                dfs_visit(n, computers, i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        g_visit = new int[n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(g_visit[j] == 0 && computers[i][j] == 1) {
                    answer++;
                    dfs_visit(n, computers, j);
                }
            }
        }

        return answer;
    }
}
