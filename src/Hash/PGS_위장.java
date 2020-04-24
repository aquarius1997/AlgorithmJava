package Hash;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class PGS_위장 {
    static public int solution(String[][] clothes) {
        int answer = 1;
        TreeMap<String, Integer> clothesKind = new TreeMap<String, Integer>();
        int i;

        //1. 옷 종류를 확인한다
        for(i=0; i<clothes.length; i++) {
            //해당 옷 종류가 이미 있으면
            if(clothesKind.containsKey(clothes[i][1]) == true) {
                //원래 개수 알아내고
                Integer numbers = clothesKind.get(clothes[i][1]);
                clothesKind.put(clothes[i][1], new Integer(numbers+1)); //하나 더한 값으로 저장
            } else { //새로운 종류면
                clothesKind.put(clothes[i][1], new Integer(1));
            }
        }

        Set<String> keySet = clothesKind.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer value = clothesKind.get(key);
            answer = answer * (value + 1);
            //System.out.println("key : " + key + ", value: " + value);
        }

        answer -= 1;

        return answer;
    }

    public static void main(String[] args) {
        String[][] clothess = {{"a", "b"}, {"c", "b"}, {"z", "x"}};

        solution(clothess);

    }
}
