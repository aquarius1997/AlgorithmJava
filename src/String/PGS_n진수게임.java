package String;

/**
 * 소요시간 : 40min
 * 체감난이도 : ***
 * FailCnt : 0
 */
public class PGS_n진수게임 {
    String nString = "";    //n진법으로 변환한 문자열

    public void getNString(int n, int t, int m) {
        nString = "";
        int num = 0;
        int tempNum = num;
        int rest = 0;
        char restCh;

        String tempStr = "";
        while(true) {
            tempStr = "";
            tempNum = num;
            while(tempNum >= n) {
                rest = tempNum % n;
                if(rest >= 10) {
                    restCh = 'A';
                    restCh += (rest - 10);
                    tempStr += restCh;
                } else {
                    tempStr += rest;
                }
                tempNum /= n;
            }
            if(tempNum >= 10) {
                restCh = 'A';
                restCh += (tempNum - 10);
                tempStr += restCh;
            } else {
                tempStr += tempNum;
            }


            for(int i=tempStr.length()-1; i>=0; i--) {
                nString += tempStr.charAt(i);
            }
            if(nString.length() > t*m) {    //종료조건
                break;
            }
            num++;
        }
    }

    public String solution(int n, int t, int m, int p) {
        String answer = "";

        getNString(n, t, m);

        int cnt = 1;
        int round = 0;
        while(true) {
            if(p == cnt) {  //자기 차례이면
                answer += nString.charAt(p+(m*round));
                round++;
            }
            cnt++;
            if(cnt > m) {
                cnt = 1;
            }
            if(answer.length() == t) {
                break;
            }
        }

        return answer;
    }
}
