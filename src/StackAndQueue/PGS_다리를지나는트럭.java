package StackAndQueue;
import java.util.*;

public class PGS_다리를지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int truckLen = truck_weights.length;
        int truckIdx= 0 ;
        int tempWeight = 0;
        int answer = 0;
        int seconds = 0;

        //각 트럭들이 다리에 올라가 나올때까지 남은 시간 저장
        int[] lastSeconds = new int[truckLen];
        Arrays.fill(lastSeconds, bridge_length);

        //0s
        queue.add(0);
        seconds = 1;
        truckIdx++;

        while(true) {
            seconds++;

            tempWeight = 0; //다리에 올라와있는 트럭들의 무게를 알아낸

            //큐에 들어있는 요소들의 남은 시간을 -1한다
            for(int i=0; i<queue.size(); i++) {
                int idx = queue.get(i);
                lastSeconds[idx] -= 1;
                tempWeight += truck_weights[idx];
            }
            //큐 프론트가 0초이면 pop
            int idx = queue.get(0);
            if(lastSeconds[idx] == 0) {
                tempWeight -= truck_weights[idx];
                queue.remove(0);
            }

            //다음 트럭이 올라갈 수 있는지 확인
            if(truckIdx < truckLen) {
                if(tempWeight + truck_weights[truckIdx] <= weight) {
                    queue.add(truckIdx);
                    truckIdx++;
                }
            }

            if(queue.isEmpty()) {   //종료
                break;
            }
        }

        answer = seconds;

        return answer;
    }
}
