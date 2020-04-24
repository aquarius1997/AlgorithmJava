package Sort;

import java.util.Arrays;

/**
 * time : 15min. difficulty : *
 */
public class PGS_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        int subLen = 0; int subIdx = 0;
        int i, j;

        answer = new int[(commands.length)];

        for(i=0; i<commands.length; i++) {
            subLen = commands[i][1] - commands[i][0] + 1;
            int[] subArray = new int[subLen];
            subIdx = 0;
            for(j=commands[i][0]-1; j<=commands[i][1]-1; j++) {
                subArray[subIdx++] = array[j];
            }

            Arrays.sort(subArray);

            answer[i] = subArray[(commands[i][2] - 1)];
        }

        return answer;
    }
}
