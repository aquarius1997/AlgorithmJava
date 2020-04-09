package Math;
import java.util.*;

public class PGS_124나라의숫자 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String answer = solution(n);
        System.out.println(answer);
    }

    /**
     * 입력으로 받은 숫자를 124숫자로 변환해 리턴한다
     * @param n 변환할 숫자(10진수)
     * @return n을 124숫자로 변환한 문자열
     * 이 문제를 두번째로 풀어보는 것이지만 이번에도 알고리즘을 혼자 생각해내지 못함
     * 꼭 다시 복습하기
     * 체감난이도 : *****
     */
    public static String solution(int n) {
        String answer = "";
        String tempAnswer = "";

        while(n > 3) {
            if(n % 3 == 0) {
                tempAnswer += "4";
                n = n / 3;
                n -= 1;
            } else if(n % 3 == 1) {
                tempAnswer += "1";
                n = n / 3;
            } else {
                tempAnswer += "2";
                n = n / 3;
            }
        }
        if(n == 3) {
            tempAnswer += "4";
        } else {
            tempAnswer += n;
        }

        for(int i=tempAnswer.length() - 1; i>=0; i--) {
            answer += tempAnswer.charAt(i);
        }


        return answer;
    }
}
