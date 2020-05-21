package DFSandBFS;

import java.util.Arrays;

public class PGS_여행경로2 {
    int g_routeCnt = 1; //경로의 총 개수
    String[] g_route = {};
    int endFlag = 0;
    String[][] airport = new String[10002][10002];  //airport[idx1][0] -> 출발지 저장, airport[idx1][1~..] -> 출발지로부터 목적지들 저장
    int[] idxTable = new int[10002];    //airport 인덱스 저장

    public void dfs_searching(String start, int idx, int startNum) {
        g_route[idx] = start;

        //경로 총 개수를 만족하면 재귀호출 종료
        if(idx+1 == g_routeCnt) {
            endFlag = 1;    return;
        }
        //경로 총 개수를 만족하지 않으면 start가 출발지가 있는지 여부에 따라 방문 안한곳으로 dfs탐색
        for(int i=0; i<startNum; i++) {
            if(airport[i][0].equals(start)) {
                for(int j=1; j<idxTable[i]; j++) {
                    if(!(airport[i][j].equals("Visited"))) {    //방문 안한곳
                        String next = airport[i][j];
                        airport[i][j] = "Visited";
                        dfs_searching(next, idx+1, startNum);
                        //원상 복구
                        airport[i][j] = next;
                        //경로 찾으면 종료
                        if(endFlag == 1) { return; }
                    }
                }
            }
        }
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int startNum = 0;   int existFlag = 0;

        //airport 초기화
        for(int i=0; i<tickets.length; i++) {
            existFlag = 0;  //같은 출발지가 있으면 1로 변경
            for(int j=0; j<startNum; j++) {
                if(airport[j][0].equals(tickets[i][0])) {
                    existFlag = 1;
                    airport[j][idxTable[j]] = tickets[i][1];   //목적지 저장
                    idxTable[j] += 1;
                    break;
                }
            }
            if(existFlag == 0) {    //해당 출발지로 첫번째 나온 티켓이면
                airport[startNum][0] = tickets[i][0];
                airport[startNum][1] = tickets[i][1];
                idxTable[startNum] = 2;
                startNum++;
            }
        }

        //airport 목적지들 정렬
        for(int i=0; i<startNum; i++) {
            Arrays.sort(airport[i], 1, idxTable[i]);
            g_routeCnt += (idxTable[i] - 1);
        }

        g_route = new String[g_routeCnt];
        dfs_searching("ICN", 0, startNum);

        answer = new String[g_routeCnt];
        for(int i=0; i<g_routeCnt; i++) {
            answer[i] = g_route[i];
        }

        return answer;
    }
}
