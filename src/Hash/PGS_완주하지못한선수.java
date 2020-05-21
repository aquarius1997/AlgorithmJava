package Hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 20min. **
 * HashMap의 활용 (Set 으로 key들을 빼내는 것과 Iterator까지)
 */
public class PGS_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        int peopleCnt = 0;
        int i;

        //참가한 사람들을 이름당 몇명인지로 저장
        for(i=0; i<participant.length; i++) {
            if(hashMap.containsKey(participant[i])) {   //동일한 이름이 있으면
                peopleCnt = hashMap.get(participant[i]);    //기존 몇명인지 알아내고
                //새로운 값으로 저장
                hashMap.put(participant[i], new Integer(peopleCnt+1));
            } else {    //동일한 이름이 아직 없으면
                hashMap.put(participant[i], new Integer(1));
            }
        }

        //완주한 사람들 이름으로 -1한다
        for(i=0; i<completion.length; i++) {
            peopleCnt = hashMap.get(completion[i]);
            //-1해서 업데이트
            hashMap.put(completion[i], new Integer(peopleCnt-1));
        }

        //값이 0 이상인 키가 정답
        Set<String> keySet = hashMap.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = hashMap.get(key);
            if(value > 0) {
                answer = key;
                break;
            }
        }


        return answer;
    }
}
