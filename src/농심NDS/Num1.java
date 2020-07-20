package 농심NDS;

/**
 * 10min
 * 만점
 */
public class Num1 {
    public String solution(String sentence) {
        String answer = "";
        int[] cntArr = new int[26];

        char ch;
        int ascii;
        //문자 카운팅하기
        for(int i=0; i<sentence.length(); i++) {
            //문자 입력한 경우(소문자)
            if(sentence.charAt(i) >= 'a' && sentence.charAt(i) <= 'z') {
                ch = sentence.charAt(i);
                ascii = ch - 'a';
                cntArr[ascii]++;
            } else if(sentence.charAt(i) >= 'A' && sentence.charAt(i) <= 'Z') { //대문자 입력
                ch = sentence.charAt(i);
                ascii = ch - 'A';
                cntArr[ascii]++;
            } else continue;
        }

        //완벽한 문자열인지 검사
        int flag = 0;   //완벽하지 않으면 1
        for(int i=0; i<26; i++) {
            if(cntArr[i] == 0) {
                flag = 1;
                ch = 'a';
                ch += i;
                answer += ch;
            }
        }

        if(flag == 0) { //완벽한 문자열
            answer = "perfect";
        }

        return answer;
    }
}
