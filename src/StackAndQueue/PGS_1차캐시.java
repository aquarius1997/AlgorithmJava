package StackAndQueue;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 35min. 2Fail. LRU 캐시의 개념을 잘못 알고 적용함 + cacheSize가 0일때 고려안함
 */
public class PGS_1차캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        String tempStr = "";    char ch;
        String popStr = "";
        LinkedList<String> cache = new LinkedList<String>();
        HashSet<String> cacheSet = new HashSet<String>();

        for(int i=0; i<cities.length; i++) {
            tempStr = "";
            for(int j=0; j<cities[i].length(); j++) {   //모두 소문자로 만들기
                if(cities[i].charAt(j) >= 'A' && cities[i].charAt(j) <= 'Z') {  //소문자로 변환해서 저장
                    ch = cities[i].charAt(j);
                    ch += ('a' - 'A');
                    tempStr += ch;
                } else {
                    tempStr += cities[i].charAt(j);
                }
            }

            if(cacheSize == 0) {
                answer += 5;
            } else {
                if (cacheSet.contains(tempStr)) {   //hit
                    for(int j=0; j<cache.size(); j++) {
                        if(cache.get(j).equals(tempStr)) {
                            cache.remove(j);    break;
                        }
                    }
                    cache.add(tempStr);
                    answer += 1;
                } else {
                    answer += 5;
                    if(cache.size() == cacheSize) { //캐시가 꽉차면
                        //앞에거(가장오래된거) 빼기
                        popStr = cache.poll();
                        cacheSet.remove(popStr);
                    }
                    //새로운거 넣기
                    cache.offer(tempStr);
                    cacheSet.add(tempStr);
                }
            }
        }

        return answer;
    }
}
