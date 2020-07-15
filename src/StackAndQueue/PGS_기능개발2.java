package StackAndQueue;

import java.util.*;

/**
 * 11min
 * Failcnt : 0
 * 체감난이도 : *
 */
public class PGS_기능개발2 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        //각 기능별로 작업을 몇일 해야하는지 저장한다
        List<Integer> days = new ArrayList<Integer>();
        int percentDiff = 100;
        int dayCnt = 0;
        for(int i=0; i<progresses.length; i++) {
            percentDiff = 100;
            percentDiff -= progresses[i];
            if(percentDiff % speeds[i] != 0) {  //배포일 +1됨
                dayCnt = (percentDiff / speeds[i]) + 1;
            } else {
                dayCnt = percentDiff / speeds[i];
            }
            days.add(dayCnt);
        }

        List<Integer> tempAnswer = new ArrayList<>();
        int cnt = 0;    //배포되는 기능 카운트
        while(!(days.isEmpty())) {
            int d = days.remove(0);
            cnt = 1;
            while(!(days.isEmpty())) {
                if(days.get(0) <= d) {
                    cnt++;
                    days.remove(0);
                } else { break; }
            }
            tempAnswer.add(cnt);
        }

        answer = new int[tempAnswer.size()];

        for(int i=0; i<tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        return answer;
    }
}
