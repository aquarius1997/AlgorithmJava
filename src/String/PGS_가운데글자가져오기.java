package String;

/**
 * 5:16 ~ 5:20
 * FailCnt : 0
 * 체감난이도 : *
 */
public class PGS_가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";

        int mid = 0;
        mid = s.length() / 2;

        if(s.length() % 2 == 0) {   //문자열 길이가 짝수이면
            answer += s.charAt(mid - 1);
        }

        answer += s.charAt(mid);

        return answer;
    }
}
