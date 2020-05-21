package Heap;

import java.util.*;

public class PGS_이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = {};
        String numStr = ""; //문자열 부분 중 숫자 알아낵
        int strToNum = 0;   int findNum = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i=0; i<operations.length; i++) {
            if(operations[i].charAt(0) == 'I') {    //삽입
                if(operations[i].charAt(2) == '-') {    //음수
                    numStr = operations[i].substring(3, operations[i].length());
                    strToNum = Integer.valueOf(numStr);
                    strToNum *= -1;
                } else {    // 양수
                    numStr = operations[i].substring(2, operations[i].length());
                    strToNum = Integer.valueOf(numStr);
                }
                //HashMap에 저장
                if(hashMap.containsKey(strToNum)) { //이미 있는 숫자면
                    hashMap.put(strToNum, new Integer(hashMap.get(strToNum) + 1));  //카운팅 +1
                } else {    //해당 숫자 첫번째이면
                    hashMap.put(strToNum, new Integer(1));
                }
                //힙에 넣기
                minHeap.add(strToNum);
                maxHeap.add(strToNum);
            } else {    //삭제
                if(operations[i].charAt(2) == '-') {    //최솟값 삭제
                    while(minHeap.size() > 0) { //minHeap 안 비어 있으면
                        findNum = minHeap.poll();   //해당 숫자 있는지 확인
                        if(hashMap.get(findNum) > 0) {
                            hashMap.put(findNum, new Integer(hashMap.get(findNum) - 1));   //개수 -1
                            break;
                        }
                    }
                } else {    //최댓값 삭제
                    while(maxHeap.size() > 0) {
                        findNum = maxHeap.poll();
                        if(hashMap.get(findNum) > 0) {
                            hashMap.put(findNum, new Integer(hashMap.get(findNum) - 1));
                            break;
                        }
                    }
                }
            }
        }

        Set<Integer> keySet = hashMap.keySet();
        Iterator<Integer> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()) {
            Integer key = keyIterator.next();
            if(hashMap.get(key) > 0) {

            }
        }


        answer = new int[2];
        //일단 없는거로 초기화
        answer[0] = answer[1] = 0;
        while(!maxHeap.isEmpty()) {
            findNum = maxHeap.poll();
            if (hashMap.get(findNum) > 0) {  //최댓값있으면
                answer[0] = findNum;
                break;
            }
        }
        while(!minHeap.isEmpty()) {
            findNum = minHeap.poll();
            if(hashMap.get(findNum) > 0) {
                answer[1] = findNum;
                break;
            }
        }

        if(answer[0] == 0 && answer[1] != 0) {
            answer[0] = answer[1];
        }
        if(answer[0] != 0 && answer[1] == 0) {
            answer[1] = answer[0];
        }


        return answer;
    }
}
