package Heap;

import java.util.PriorityQueue;

/**
 * 체감난이도 : *****
 * 소요시간 : 52min
 * FailCnt : 2
 *
 * TC : stock = 4, date = [4, 10, 15], supplies = [11, 1, 2], k = 18 같은 경우 고려하기
 */
public class PGS_라면공장2 {

    public class Supply implements Comparable<Supply>{
        int date;   //공급날짜
        int supply; //공급량

        public Supply(int date, int supply) {
            this.date = date;
            this.supply = supply;
        }

        //공급량이 많은게 루트쪽에 위치하도록
        @Override
        public int compareTo(Supply supply) {
            if(this.supply < supply.supply) return 1;
            else if(this.supply == supply.supply) return 0;
            else return -1;
        }
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int idx = 0;
        int endDay = stock; //현재 밀가루가 바닥이 나는 날짜
        int day = 0;    //기준날짜
        PriorityQueue<Supply> supplyPriorityQueue = new PriorityQueue<>();

        while(true) {
            if(endDay >= k) break;

            while(idx<dates.length) {//현재 밀가루가 바닥이 날 예상 날짜(endDay)보다 공급예정 날짜가 작거나 같으면 힙에 넣는다
                if(dates[idx] <= endDay) {
                    supplyPriorityQueue.add(new Supply(dates[idx], supplies[idx]));
                    idx++;
                } else break;
            }
            //공급양이 제일 많은 날짜에 공급받는다
            Supply maxSupply = supplyPriorityQueue.poll();
            if(maxSupply.date > day) {
                stock -= (maxSupply.date - day);
            }
            stock += (maxSupply.supply);
            if(maxSupply.date > day) {
                day = maxSupply.date;   //기준날짜 변경
            }
            endDay = day + stock;
            answer++;
        }

        return answer;
    }
}
