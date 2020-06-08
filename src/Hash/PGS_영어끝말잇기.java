package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 22min 0fail
 */
public class PGS_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int pNum = 1;   int round = 1;
        char ch;
        int idx = 0;    //words인덱스

        Set<String> wordSet = new HashSet<String>();

        //첫번째 문자는 넣고 시작
        wordSet.add(words[idx]);
        ch = words[idx].charAt(words[idx].length()-1);  //마지막 문자
        idx++;
        pNum++;

        while(idx < words.length) {

            //탈락
            if(ch != words[idx].charAt(0) || wordSet.contains(words[idx])) {
                answer[0] = pNum;
                answer[1] = round;
                break;
            }

            ch = words[idx].charAt(words[idx].length()-1);
            wordSet.add(words[idx]);
            idx++;

            if(pNum == n) {
                pNum = 1;
                round++;    //몇번째 차례인지
            } else {
                pNum++;
            }
        }

        return answer;
    }
}
