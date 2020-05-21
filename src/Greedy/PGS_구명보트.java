package Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class PGS_구명보트 {
    /**
     * 제일 무거운 사람과 제일 가벼운 사람을 합쳐서 태울 수 있다면 둘을 태워 보낸다. 그렇지 않은 경우 제일 무거운 사람만 태워 보낸다.
     * @param people 사람들의 무게
     * @param limit 보트 무게 제한
     * @return 구명보트 개수 최솟값
     */
    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] sortedPeople = new int[people.length];

        for(int i=0; i<people.length; i++) {
            sortedPeople[i] = people[i];
        }

        Arrays.sort(sortedPeople);

        int startIdx = 0;
        int endIdx = sortedPeople.length - 1;

        while(startIdx <= endIdx) {
            if(startIdx == endIdx) {
                answer++;
                break;
            } else {
                if(sortedPeople[endIdx] + sortedPeople[startIdx] <= limit) {
                    startIdx++;
                    endIdx--;
                } else {
                    endIdx--;
                }
                answer++;
            }
        }

        return answer;
    }
}
