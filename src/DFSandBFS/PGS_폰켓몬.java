package DFSandBFS;

import java.util.Arrays;
import java.util.Collections;

public class PGS_폰켓몬 {



    public int solution(int[] nums) {
        int answer = 0;
        Integer[] cntArr = new Integer[200001];

        Arrays.fill(cntArr, 0);

        //각 종류당 몇마리 있는지 저장
        for(int i=0; i<nums.length; i++) {
            cntArr[(nums[i])]++;
        }

        //내림차순으로 정렬
        Arrays.sort(cntArr, Collections.reverseOrder());

        for(int i=0; i<nums.length/2; i++) {
            if(cntArr[i] == 0) { break;}
            answer++;
        }

        return answer;
    }

/*    public static void main(String[] args) {
        Integer[] intarr = new Integer[2];

        intarr[0] = 0;
        System.out.println(intarr[0]);
    }*/
}
