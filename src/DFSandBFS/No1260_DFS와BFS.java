package DFSandBFS;
import java.util.*;

public class No1260_DFS와BFS {
    static int N, M, V;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int u, v;
        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();

        //초기화
        visited = new int[1010];
        graph = new ArrayList<ArrayList<Integer>>(1010);    //ArrayList의 배열 만들기
        for(int i=0; i<1010; i++) {
            graph.add(new ArrayList<Integer>());
        }
        queue = new LinkedList<Integer>();

        //그래프 정보를 입력받음
        for(int i=0; i<M; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            //무방향그래프
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs_func(V);

        for(int i=0; i<1010; i++) {
            visited[i] = 0;
        }

        System.out.println();

        bfs_func(V);

    }

    /**
     * 시작 정점을 입력 받아 해당 정점으로 부터 그래프를 DFS 탐색
     * @param v 시작정점 번호
     */
    public static void dfs_func(int v) {
        int minV;   //방문하지 않은 최소 정점
        int flag;   //인접 정점에 대해 모두 방문했는지 여부를 살핀다

        visited[v] = 1;
        System.out.print(v + " ");

        do {
            flag = 0;
            minV = 987987987;
            for(int i=0; i<graph.get(v).size(); i++) {
                //방문하지 않은 정점 중 최소 정점 찾기
                if(visited[(graph.get(v).get(i))] == 0) {
                    flag = 1;
                    if(minV > graph.get(v).get(i)) {
                        minV = graph.get(v).get(i);
                    }
                }
            }
            if(flag == 1) {
                //방문안한 최소 정점에 대해 dfs_func호출
                dfs_func(minV);
            }
        } while(flag == 1);
    }

    public static void bfs_func(int v) {
        int frontN, minV;
        int flag;

        queue.offer(v);
        visited[v] = 1;

        //큐가 빌때까지 반복
        while(!queue.isEmpty()) {
            frontN = queue.poll();
            System.out.print(frontN + " ");
            do {
                flag = 0;
                minV = 987987987;

                //모든 인접 노드들에 대하여 방문안한 최소 노드를 찾는다
                for(int i =0; i<graph.get(frontN).size(); i++) {
                    if(visited[(graph.get(frontN).get(i))] == 0) {
                        flag = 1;
                        if(minV > graph.get(frontN).get(i)) {
                            minV = graph.get(frontN).get(i);
                        }
                    }
                }
                if(flag == 1) {
                    queue.offer(minV);
                    visited[minV] = 1;
                }
            } while(flag == 1);
        }
    }
}
