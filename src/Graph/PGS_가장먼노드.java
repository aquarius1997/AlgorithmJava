package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PGS_가장먼노드 {
    ArrayList<ArrayList<Integer>> g_graph;
    int[] g_dist = new int[20002];
    int g_maxDist = 0;

    /**
     * 시작 정점 번호로부터 각 노드로의 최단 거리를 구한다
     * @param node 시작정점 번호
     */
    public void get_dist(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int nodeNum = 0; int nextDist = 0;

        //처음 방문 노드 번호와 거리를 삽입
        queue.add(node);
        g_dist[node] = 1;
        g_maxDist = 1;

        while(!queue.isEmpty()) {
            nodeNum = queue.poll();
            nextDist = g_dist[nodeNum] + 1;

            //방문 안한 인접정점이거나 더 짧은 거리로 이동가능하면
            for(int i=0; i<g_graph.get(nodeNum).size(); i++) {
                if(g_dist[g_graph.get(nodeNum).get(i)] == 0 || g_dist[g_graph.get(nodeNum).get(i)] > nextDist) {
                    //노드 거리 저장, 큐에 삽입
                    g_dist[g_graph.get(nodeNum).get(i)] = nextDist;
                    queue.add(g_graph.get(nodeNum).get(i));
                    //가장 먼 거리 업데이트
                    if(g_maxDist < nextDist) {
                        g_maxDist = nextDist;
                    }
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        //전역변수 할당
        g_graph = new ArrayList<ArrayList<Integer>>(20001);
        for(int i=0; i<20001; i++) {
            g_graph.add(new ArrayList<Integer>());
        }

        //양방향 그래프 초기화
        for(int i=0; i<edge.length; i++) {
            g_graph.get(edge[i][0]).add(edge[i][1]);
            g_graph.get(edge[i][1]).add(edge[i][0]);
        }

        get_dist(1);

        for(int i=0; i<20002; i++) {
            if(g_maxDist == g_dist[i]) {
                answer++;
            }
        }

        return answer;
    }
}
