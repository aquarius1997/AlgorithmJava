package Heap;

import java.util.PriorityQueue;

public class PGS_라면공장 {
    class RamenSupply implements Comparable<RamenSupply> {
        int date;
        int supply;

        public RamenSupply(int date, int supply) {
            this.date = date;
            this.supply = supply;
        }

        // 공급량이 많은 것이 우선순위 높게
        @Override
        public int compareTo(RamenSupply ramenSupply) {
            if(this.supply <= ramenSupply.supply) return 1;
            else return -1;
        }
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int remain, day, preday, maxday;
        int datesIdx = 0;
        PriorityQueue<RamenSupply> priorityQueue = new PriorityQueue<RamenSupply>();

        day = preday = maxday = 0;
        remain = stock;

        while(true) {
            maxday = day + stock;

            if(maxday >= k) break;

            for(; datesIdx<dates.length; datesIdx++) {
                if(dates[datesIdx] <= maxday) { //최대 운영가능한 날짜까지 힙에 넣는다
                    priorityQueue.add(new RamenSupply(dates[datesIdx], supplies[datesIdx]));
                } else {
                    break;
                }
            }

            preday = day;
            //최대 공급날이 몇일인지 알아내서 해당 날짜로 저장
            day = priorityQueue.peek().date;
            stock = stock - (day - preday) + priorityQueue.poll().supply;

            answer++;
        }

        return answer;
    }
}
