package String;

public class PGS_큰수만들기 {
    public String solution(String number, int k) {
        String answer = "";
        int stringLen = 0;   //만들어야 할 문자열의 길이를 저장
        int startIdx, endIdx; //탐색할 범위의 마지막 인덱스
        int maxIdx, maxNum;

        stringLen = (number.length()) - k;

        maxIdx = startIdx = 0;
        //탐색의 마지막 인덱스 정하기
        endIdx = number.length() - stringLen;
        maxNum = -1;
        while(endIdx < number.length()) {
            if(number.charAt(startIdx) - '0' > maxNum) {
                maxNum = number.charAt(startIdx) - '0';
                maxIdx = startIdx;
            }
            startIdx++;
            if(startIdx > endIdx) {
                endIdx++;
                maxNum = -1;
                answer += number.charAt(maxIdx);
                startIdx = maxIdx + 1;
            }
        }


        return answer;
    }
}
