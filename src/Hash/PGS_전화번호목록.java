package Hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PGS_전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<String>();
        int i;

        //첫번째 전화번호 추가
        set.add(phone_book[0]);
        //두번째 전화번호 부터 확인
        for(i=1; i<phone_book.length; i++) {
            Iterator<String> iterator = set.iterator();

            while(iterator.hasNext()) {
                String element = iterator.next();
                int StringLen = element.length();
                String phoneBookI = phone_book[i];

                if(phoneBookI.length() < StringLen) {   //지금 비교할 문자열이 저장된 문자열보다 짧으면 이터레이터문자열을 길이만큼 잘름
                    element = element.substring(0, phoneBookI.length());
                } else if(phoneBookI.length() > StringLen) { //지금 비교할 문자열이 더 길면 짤라서 확인
                    phoneBookI = phoneBookI.substring(0, StringLen);
                }

                //접두어로 가지는지 확인
                if(phoneBookI.equals(element)) {
                    answer = false;
                    break;
                }
            }

            set.add(phone_book[i]);
            if(answer == false) { break; }
        }

        return answer;
    }
}
