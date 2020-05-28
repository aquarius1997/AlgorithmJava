package SummerCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Num2 {
    public int[] solution(int total_sp, int[][] skills) {
        int[] answer;
        int N = skills.length + 1;  //전체 노드의 개수
        int checkedN = 0;   //확인한 노드의 개수
        int[] parent = new int[N+2];    //부모 번호 저장
        int[] visit = new int[N+2];
        int[] checkedChildCnt = new int[N+2];
        int[] childCnt = new int[N+2];
        HashMap<Integer, ArrayList<Integer>> child = new HashMap<Integer, ArrayList<Integer>>();

        int[] sum = new int[N+2];
        int tempRoot = 0;   int x = 0;
        int p, c;

        for(int i=0; i<skills.length; i++) {
            p = skills[i][0];
            c = skills[i][1];

            parent[c] = p;  //자기의 부모 번호를 저장
            childCnt[p]++;  //부모는 자식의 개수를 카운팅
            if(child.containsKey(p)) {
                ArrayList<Integer> list = child.get(p);
                list.add(c);
                child.put(p, list);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(c);
                child.put(p, list);
            }
        }

        //모두 확인할때까지
        while(true) {
            //방문 안했고자식개수와 확인한 자식의 개수가 동일하면
            for(int i=1; i<=N; i++) {
                if(visit[i] == 0) {
                    if(childCnt[i] == checkedChildCnt[i]) {
                        p = parent[i];  //부모 번호 알아내고
                        //부모의 자기 sum을 누적하는데 만일 sum이 0이면 1로 누적
                        if(sum[i] == 0) {
                            sum[p] += 1;
                        } else {
                            sum[p] += sum[i];
                        }
                        //방문처리
                        visit[i] = 1;
                        //부모의 확인한 자식의 수를 +1
                        checkedChildCnt[p] += 1;
                        //노드 확인 개수 카운팅
                        checkedN++;
                        //최상위 노드로 일단 임시 저장
                        tempRoot = i;
                    }
                }
            }

            if(checkedN == N) { break; }    //모든 노드 확인하면
        }

        int div = 0;
        for(int i=1; i<=N; i++) {
            if(sum[i] == 0) {
                div += 1;
            } else {
                div += sum[i];
            }
        }
        //분배값 구하고
        x = total_sp / div;

        answer = new int[N];  int idx = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        int tempNode = 0;
        queue.offer(tempRoot);
        while(!queue.isEmpty()) {
            tempNode = queue.poll();
            //answer에 저장
            if(sum[tempNode] == 0) {
                answer[idx] = x;
            } else {
                answer[idx] = x * sum[tempNode];
            }
            idx++;

            if(child.containsKey(tempNode)) {
                ArrayList<Integer> list = child.get(tempNode);
                while(!list.isEmpty()) {
                    queue.offer(list.get(0));
                    list.remove(0);
                }
            }

        }

        return answer;
    }
}
