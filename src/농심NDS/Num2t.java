package 농심NDS;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 1h 54남음
 * 마만점
 */
public class Num2t {
    public int solution(int[] goods, int[] boxes){
        int answer = 0;

        Arrays.sort(goods);
        Arrays.sort(boxes);

        int cnt = 0;
        int boxIdx = 0;
        for(int i=0; i<goods.length;) {
            if(goods[i] <= boxes[boxIdx]) {
                cnt++;  boxIdx++;   i++;
            } else {
                boxIdx++;
            }
            if(boxIdx >= boxes.length) {    //이후 담을수 있는 상자 없으
                break;
            }
        }

        answer = cnt;

        return answer;
    }
}
