package Sort;

import java.util.Arrays;

public class PGS_hIndex {
    public int solution(int[] citations) {
        int answer = 0;
        int[] sortedCitations = new int[citations.length];  //citations 배열을 정렬해 저장

        for(int i=0; i<citations.length; i++) {
            sortedCitations[i] = citations[i];
        }

        Arrays.sort(sortedCitations);

        int h = 0;  int lastMax = 0;
        for(int i=0; i<sortedCitations.length; i++) {
            h = sortedCitations[i];
            int overNum = sortedCitations.length - i;   //h번 이상 인용된 개수
            if(i-1 >= 0) {  //나머지 논문들의 인용수 최대값
                lastMax = sortedCitations[i-1];
            }
            if(overNum >= h && lastMax <= h) {
                answer = h;
            } else {    //아래로 내려가며 최댓값 찾는다
                for(int j=h; j>answer; j--) {
                    if(j >= lastMax && overNum >= j) {
                        answer = j;
                    }
                }
                break;
            }
        }

        return answer;
    }
}
