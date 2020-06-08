package BruteForce;

/**
 * 40min 0Fail
 */
public class PGS_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        int answer = 0;
        String[] str1Element;   String[] str2Element;
        int str1Idx, str2Idx;

        str1Idx = 0;
        str2Idx = 0;
        str1Element = new String[str1.length()-1];
        str2Element = new String[str2.length()-1];

        String element = "";
        char tempCh;
        //str1의 집합 만들기
        for(int i=0; i<str1.length()-1; i++) {
            if((str1.charAt(i) >= 'a' && str1.charAt(i) <='z') || (str1.charAt(i) >= 'A' && str1.charAt(i) <='Z')) {
                if((str1.charAt(i+1) >= 'a' && str1.charAt(i+1) <='z') || (str1.charAt(i+1) >= 'A' && str1.charAt(i+1) <='Z')) {
                    element = "";
                    tempCh = str1.charAt(i);
                    if(str1.charAt(i) >= 'A' && str1.charAt(i) <='Z') { //대문자면 소문자로 변환
                        tempCh += ('a' - 'A');
                    }
                    element += tempCh;
                    tempCh = str1.charAt(i+1);
                    if(str1.charAt(i+1) >= 'A' && str1.charAt(i+1) <='Z') { //대문자면 소문자로 변호나
                        tempCh += ('a' - 'A');
                    }
                    element += tempCh;
                    str1Element[str1Idx] = element;
                    str1Idx++;
                }
            }
        }
        //str2의 집합 만들기
        for(int i=0; i<str2.length()-1; i++) {
            if((str2.charAt(i) >= 'a' && str2.charAt(i) <='z') || (str2.charAt(i) >= 'A' && str2.charAt(i) <='Z')) {
                if((str2.charAt(i+1) >= 'a' && str2.charAt(i+1) <='z') || (str2.charAt(i+1) >= 'A' && str2.charAt(i+1) <='Z')) {
                    element = "";
                    tempCh = str2.charAt(i);
                    if(str2.charAt(i) >= 'A' && str2.charAt(i) <='Z') { //대문자면 소문자로 변환
                        tempCh += ('a' - 'A');
                    }
                    element += tempCh;
                    tempCh = str2.charAt(i+1);
                    if(str2.charAt(i+1) >= 'A' && str2.charAt(i+1) <='Z') { //대문자면 소문자로 변호나
                        tempCh += ('a' - 'A');
                    }
                    element += tempCh;
                    str2Element[str2Idx] = element;
                    str2Idx++;
                }
            }
        }

        //교집합의 수 구하기
        int[] visit = new int[str1Idx];
        int includeCnt = 0; //합집합수
        for(int i=0; i<str2Idx; i++) {
            for(int j=0; j<str1Idx; j++) {
                if(str2Element[i].equals(str1Element[j]) && visit[j] == 0) {
                    visit[j] = 1;
                    includeCnt++;
                    break;
                }
            }
        }

        double tempAnswer = 0.0;
        if(str1Idx + str2Idx == 0) {    //둘다 공집합이면
            tempAnswer = 1;
        } else {
            tempAnswer = (double)includeCnt / (str1Idx + str2Idx - includeCnt);
        }

        tempAnswer *= 65536;
        answer = (int)tempAnswer;

        return answer;
    }

}
