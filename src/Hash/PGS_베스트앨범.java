package Hash;

import java.util.*;

//*****

public class PGS_베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        HashMap<String, Integer> genresMap = new HashMap<String, Integer>();
        HashMap<String, Integer> maxMap = new HashMap<String, Integer>();
        HashMap<String, Integer> maxIndex = new HashMap<String, Integer>();
        HashMap<String, Integer> secondMaxMap = new HashMap<String, Integer>();
        HashMap<String, Integer> secondMaxIndex = new HashMap<String, Integer>();
        int answerCnt = 0;
        int preMaxValue = 0;
        int preMaxIndex = 0;
        String entryKey;
        int i;

        for(i=0; i<genres.length; i++) {
            //장르에 속한 곡이 하나 이상일 경우
            if(genresMap.containsKey(genres[i])) {
                if(secondMaxIndex.get(genres[i]) == -1) {   //두개까지만 answer개수를 카운팅하려고
                    answerCnt++;
                }
                genresMap.put(genres[i], new Integer(genresMap.get(genres[i]) + plays[i]));    //누적해서 더한다
                //현재 값이 해당 장르의 max값보다 크면
                if(plays[i] > maxMap.get(genres[i])) {
                    preMaxValue = maxMap.get(genres[i]);    //원래 가장 컸던 값 저장해두고 secondMax랑 비교해야함
                    preMaxIndex = maxIndex.get(genres[i]);
                    maxMap.put(genres[i], new Integer(plays[i]));   //새로운 값으로 저장
                    maxIndex.put(genres[i], i);
                    if(preMaxValue > secondMaxMap.get(genres[i])) { //secondMax update 여부 확인
                        secondMaxMap.put(genres[i], new Integer(preMaxValue));
                        secondMaxIndex.put(genres[i], preMaxIndex);
                    }
                } else { //현재 값이 해당 장르의 max보다 작으면 secondMax랑만 비교
                    if(plays[i] > secondMaxMap.get(genres[i])) {
                        secondMaxMap.put(genres[i], new Integer(plays[i]));
                        secondMaxIndex.put(genres[i], new Integer(i));
                    }
                }
            } else {    //해당 장르가 첫번째로 등장한 경우
                genresMap.put(genres[i], plays[i]);
                maxMap.put(genres[i], plays[i]);    //최댓값으로 저장
                secondMaxMap.put(genres[i], new Integer(-1));   //없음으로 저장
                maxIndex.put(genres[i], i);
                secondMaxIndex.put(genres[i], new Integer(-1));
                answerCnt++;
            }
        }

        //내림차순으로 정렬된 결과 가져오기
        List<Map.Entry<String, Integer>> listEntries = new ArrayList<Map.Entry<String, Integer>>(genresMap.entrySet());
        Collections.sort(listEntries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> ob1, Map.Entry<String, Integer> ob2) {
                return ob2.getValue().compareTo(ob1.getValue());
            }
        });

        answer = new int[answerCnt];
        int answerIdx = 0;

        //정답알아내기
        for(Map.Entry<String, Integer> entry : listEntries) {
            answer[answerIdx] = maxIndex.get(entry.getKey());
            answerIdx++;
            if(secondMaxIndex.get(entry.getKey()) != -1) {  //두번째로 큰 값 있으면
                answer[answerIdx] = secondMaxIndex.get(entry.getKey());
                answerIdx++;
            }
        }
        return answer;
    }
}
