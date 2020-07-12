package Sort;

import java.util.Arrays;

/**
 * 소요시간 : 30min
 * FailCnt(fail) : 0
 * 체감난이도 : ***
 */
public class PGS_튜플 {

    public class ElementData implements Comparable<ElementData> {
        int num;    //원소의 숫자
        int cnt;    //원소의 숫자가 몇 번 나타났는지 카운팅해 저장

        public ElementData(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(ElementData elementData) { //내림차순 정렬
            if(this.cnt < elementData.cnt) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public int[] solution(String s) {
        int[] answer = {};
        ElementData[] cntArr = new ElementData[100002];
        int answerIdx = 0;

        for(int i=0; i<100002; i++) {   //초기화
            cntArr[i] = new ElementData(i, 0);
        }

        int tempNum = 0;
        //숫자로 변환해서 카운팅하기
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {  //숫자이면
                if(tempNum == 0) {  //첫번째로 시작하는 숫자이면
                    tempNum = s.charAt(i) - '0';
                } else {
                    tempNum *= 10;
                    tempNum += (s.charAt(i) - '0');
                }
            } else if(s.charAt(i) == ',' || s.charAt(i) == '}') {
                if(tempNum != 0) {
                    //원소 만들어서 카운팅하고 tempNum초기화
                    if(cntArr[tempNum].cnt == 0) {
                        answerIdx++;
                    }
                    cntArr[tempNum].cnt += 1;
                    tempNum = 0;
                }
            }
        }

        //카운팅 된 숫자로 내림차순 정렬하기
        Arrays.sort(cntArr);

        answer = new int[answerIdx];

        for(int i=0; i<answerIdx; i++) {
            answer[i] = cntArr[i].num;
        }

        return answer;
    }
}
