package DFSandBFS;

import java.util.*;

public class PGS_여행경로3 {
    List<String> answerList = new ArrayList<>();
    Map<String, ArrayList<Ticket>> ticketMap = new HashMap<>();
    int ticketCnt = 0;

    public class Ticket implements Comparable<Ticket>{
        String dest;   //목적지정보
        int visit;  //방문했으면 1

        public Ticket(String dest, int visit) {
            this.dest = dest;
            this.visit = visit;
        }

        @Override
        public int compareTo(Ticket ticket) {   //사전순 정렬
            return this.dest.compareTo(ticket.dest);
        }
    }

    public void dfsSearch(List<String> resultList, int cnt, String start) {
        resultList.add(start);  //출발지 저장

        if(cnt >= ticketCnt) {
            answerList.addAll(resultList);  //깊은복사
        } else {
            if(ticketMap.containsKey(start)) {
                //start에 해당하는 티켓의 destination을 알아낸다
                String destination = "";
                ArrayList<Ticket> ticketArrayList = ticketMap.get(start);
                for(int i=0; i<ticketArrayList.size(); i++) {
                    if(ticketArrayList.get(i).visit == 0) { //방문안한곳 찾아서 방문
                        ticketArrayList.get(i).visit = 1;
                        destination = ticketArrayList.get(i).dest;
                        dfsSearch(resultList,cnt+1, destination);
                        ticketArrayList.get(i).visit = 0;
                        if(answerList.size() > 0) { break; }
                    }
                }
            }
        }

        resultList.remove(resultList.size()-1);
    }

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        ticketCnt = tickets.length;

        for(int i=0; i<tickets.length; i++) {
            if(!(ticketMap.containsKey(tickets[i][0]))) {
                ticketMap.put(tickets[i][0], new ArrayList<Ticket>());
            }
            ArrayList<Ticket> ticketList = ticketMap.get(tickets[i][0]);
            ticketList.add(new Ticket(tickets[i][1], 0));
        }

        //목적지를 사전순으로 정렬한다
        Set<String> keySet = ticketMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            ArrayList<Ticket> value = ticketMap.get(key);   //리스트 가져와서
            Collections.sort(value);    //정렬하고
        }

        List<String> resultList = new ArrayList<>();
        dfsSearch(resultList, 0, "ICN");

        answer = new String[answerList.size()];

        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
