package String;

public class PGS_JadenCase문자열만들기 {
    public String solution(String s) {
        String answer = "";
        int flag = 1;   //공백이면 1, 아님 0

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == ' ') {
                flag = 1;
            } else {
                if(flag == 1) {
                    if(ch >= 'a' && ch <= 'z') {
                        ch += ('A' - 'a');
                    }
                    flag = 0;
                } else {
                    if(ch >= 'A' && ch <= 'Z') {
                        ch -= ('A' - 'a');
                    }
                }
            }
            answer += ch;
        }
        return answer;
    }
}
