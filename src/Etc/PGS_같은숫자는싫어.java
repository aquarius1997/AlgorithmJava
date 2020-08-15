package Etc;

import java.util.*;

/**
 * 5:24 ~ 5:30
 * FailCnt : 0
 * 체감난이도 : *
 */
public class PGS_같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> answerTemp = new ArrayList();
        int arrSize = 0;

        int preNum = arr[0];    //첫번째 숫자
        answerTemp.add(preNum);

        for(int idx=1; idx<arr.length; idx++) {
            if(preNum == arr[idx])  continue;

            preNum = arr[idx];
            answerTemp.add(preNum);
        }

        answer = new int[answerTemp.size()];
        for(int idx=0; idx<answerTemp.size(); idx++) {
            answer[idx] = answerTemp.get(idx);
        }

        return answer;
    }
}
