package Math;

/**
 * 소요시간 : 15min
 * 체감난이도 : *
 * FailCnt : 1
 */
public class PGS_2016년 {
    //참고해서 만든 코드
    public String solution(int a, int b) {
        String answer = "";
        int[] calender = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] date = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int diffDay = 0 ;

        if(a == 1) {
            diffDay += (b - 1);
        } else {
            for(int calen=1; calen<a; calen++) {
                diffDay += calender[calen-1];
            }
            diffDay += (b - 1);
        }

        answer = date[(diffDay%7)];

        return answer;
    }
}
