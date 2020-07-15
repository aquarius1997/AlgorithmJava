package Heap;

import java.util.PriorityQueue;

/**
 * 소요시간 : 11min
 * FailCnt : 0
 * 체감난이도 : *
 */
public class PGS_더맵게2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilleMinHeap = new PriorityQueue<>();

        //min-heap 초기화
        for(int i=0; i<scoville.length; i++) {
            scovilleMinHeap.add(scoville[i]);
        }

        int cnt = 0;
        while(scovilleMinHeap.size() >= 1) {
            if(scovilleMinHeap.size() == 1) {
                if(scovilleMinHeap.peek() < K) {    //모든 음식을 K이상으로 만들 수 없는 경우
                    cnt = -1;
                }
                scovilleMinHeap.poll();
            } else {
                if(scovilleMinHeap.peek() >= K) {   //더이상 섞을 필요 없을경우
                    answer = cnt; break;
                } else {
                    int food1 = scovilleMinHeap.poll();
                    int food2 = scovilleMinHeap.poll();
                    int mixedFood = food1 + (food2 * 2);
                    scovilleMinHeap.add(mixedFood);
                    cnt++;
                }
            }
        }

        answer = cnt;

        return answer;
    }
}
