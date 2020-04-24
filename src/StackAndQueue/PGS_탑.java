package StackAndQueue;

import java.util.Arrays;

public class PGS_탑 {
    public int[] solution(int[] heights) {
        int[] answer = {};
        int heightsLen = heights.length;
        int i, j;

        answer = new int[heightsLen];
        Arrays.fill(answer, 0); //일단 모두 수신하는 곳 없음으로 초기화

        for(i=heights.length-1; i>=0; i--) {  //마지막 탑부터 왼쪽으로 수신 탑 찾
            for(j=i-1; j>=0; j--) {
                if(heights[j] > heights[i]) {
                    answer[i] = j+1;  //수신지의 인덱스 저장
                    break;
                }
            }
        }

        return answer;
    }
}
