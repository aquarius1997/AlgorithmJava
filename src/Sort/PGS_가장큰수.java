package Sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 1h10min. ****
 */
public class PGS_가장큰수 {

    class NumCompare implements Comparable<NumCompare> {
        int num;

        public NumCompare(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(NumCompare numCompare) {
            int num1, num2;

            num1 = this.num;
            if(numCompare.num < 10) {
                num1 = num1 * 10 + numCompare.num;
            } else if(numCompare.num < 100) {
                num1 = num1 * 100 + numCompare.num;
            } else if(numCompare.num < 1000) {
                num1 = num1 * 1000 + numCompare.num;
            } else {
                num1 = num1 * 10000 + numCompare.num;
            }

            num2 = numCompare.num;
            if(this.num < 10) {
                num2 = num2 * 10 + this.num;
            } else if(this.num < 100) {
                num2 = num2 * 100 + this.num;
            } else if(this.num < 1000) {
                num2 = num2 * 1000 + this.num;
            } else {
                num2 = num2 * 10000 + this.num;
            }

            if(num1 > num2) {
                return -1;
            } else if(num1 < num2) {
                return 1;
            } else return 0;
        }
    }

    public String solution(int[] numbers) {
        String answer = "";
        int maxNum = 0;
        int num = 0;
        int maxDigit = 1;
        int i, j;


        //정렬된 값 저장할 배열
        NumCompare[] sortedNumbers = new NumCompare[numbers.length];


        for(i=0; i<numbers.length; i++) {
            sortedNumbers[i] = new NumCompare(numbers[i]);
        }

        //정렬
        Arrays.sort(sortedNumbers);

        for(i=0; i<numbers.length; i++) {
            answer += sortedNumbers[i].num;
        }


        if(answer.charAt(0) == '0') {
            answer = "0";
        }
        return answer;
    }
}
