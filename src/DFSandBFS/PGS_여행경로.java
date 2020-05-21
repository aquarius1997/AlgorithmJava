package DFSandBFS;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 2h 20min. 3Fail. *****
 */
public class PGS_여행경로 {
    //하나의 key에 value 여러개 매달기
    HashMap<String, ArrayList<String>> g_airport = new HashMap<String, ArrayList<String>>();
    String[] g_route = {};
    int g_routeCnt = 1;
    int g_flag = 0;

    public void dfs_search(String from, int idx) {

        g_route[idx] = from;

        if(idx+1 == g_routeCnt) {
            g_flag = 1; return;
        }
        if(g_airport.containsKey(from)) {
            ArrayList<String> list = g_airport.get(from);
            for(int i=0; i<list.size(); i++) {
                if(list.get(i) != "Visited") {
                    String next = list.get(i);
                    list.set(i, "Visited");
                    g_airport.put(from, list);
                    dfs_search(next, idx+1);

                    if(g_flag == 0) {
                        list.set(i, next);
                        g_airport.put(from, list);
                    } else { return; }
                }
            }
        }
    }


    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int i, j;


        //그래프 정보로 입력받아서 g_airport 초기화
        for(i=0; i<tickets.length; i++) {
            if(g_airport.containsKey(tickets[i][0])) {  //이미 값이 있으면 ArrrayList 뒤에 매달기
                ArrayList<String> list = g_airport.get(tickets[i][0]);
                list.add(tickets[i][1]);
                g_airport.put(tickets[i][0], list);
            } else {    //해당 키가 처음이면
                ArrayList<String> list = new ArrayList<String>();   //객체 생성하고
                list.add(tickets[i][1]);
                g_airport.put(tickets[i][0], list);
            }
        }

        //g_airport key별로 value 정렬
        Set<String> keySet = g_airport.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            String key = keyIterator.next();
            ArrayList<String> list = g_airport.get(key);
            //라우팅 경로 카운팅
            g_routeCnt += list.size();
            Collections.sort(list);
            g_airport.put(key, list);
        }

        //정렬 결과를 활용해서 DFS 탐색
        g_route = new String[g_routeCnt];
        dfs_search("ICN", 0);

        //정렬 결과 answer로 넣기
        answer = new String[g_routeCnt];
        for(i=0; i<g_routeCnt; i++) {
            answer[i] = g_route[i];
            System.out.println(answer[i]);
        }


        return answer;
    }
}
