package Heap;

import java.util.PriorityQueue;

//15min. **

public class PGS_더맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        int minScoville, secondScoville, newScoville;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();

        int i;

        //스코빌 모두 추가
        for(i=0; i<scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        //원소가 2개이상일때까지 확인
        while(priorityQueue.size() > 1) {
            if(priorityQueue.peek() < K){   //가장 작은 원소가 K미만일 경우 두개 꺼내서 계산하고 집어넣는
                minScoville = priorityQueue.poll();
                secondScoville = priorityQueue.poll();
                newScoville = minScoville + (2*secondScoville);
                priorityQueue.add(newScoville);
                answer++;
            } else {
                break;
            }
        }

        //불가능
        if(priorityQueue.size() == 1 && priorityQueue.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}
