package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 체감난이도 : ***
 * String 다루기에 좋은 문제
 */
public class PGS_압축 {
    public int[] solution(String msg) {
        int[] answer = {};
        HashSet<String> wordSet = new HashSet<String>();
        LinkedList<String> indexList = new LinkedList<String>();
        ArrayList<Integer> tempAnswer = new ArrayList<Integer>();
        String tempMsg = msg;

        System.out.println("tempMSg : " + tempMsg);

        //색인 초기화
        String tempStr = "";
        for(char ch='A'; ch<='Z'; ch++) {
            tempStr = "";
            tempStr += ch;
            indexList.add(tempStr);
            wordSet.add(tempStr);
        }

        while(tempMsg.length() > 0) {
            tempStr = "";
            for(int i=0; i<tempMsg.length(); i++) {
                tempStr += tempMsg.charAt(i);
                if(!(wordSet.contains(tempStr))) {  //이번거 제외한 스트링의 인덱스 알아내기
                    tempStr = tempStr.substring(0, tempStr.length()-1);
                    for(int j=0; j<indexList.size(); j++) { //인덱스 번호 알아내서 tempAnswer에 저장
                        if(indexList.get(j).equals(tempStr)) {
                            tempAnswer.add(j+1);
                            break;
                        }
                    }
                    tempStr += tempMsg.charAt(i);
                    wordSet.add(tempStr);
                    indexList.add(tempStr);
                    tempMsg = tempMsg.substring(tempStr.length()-1, tempMsg.length());
                    break;
                } else {
                    if(tempStr.length() == tempMsg.length()) {  //!! 처음에 이거 고려 안해서 무한루프돌았음
                        for(int j=0; j<indexList.size(); j++) { //인덱스 번호 알아내서 tempAnswer에 저장
                            if(indexList.get(j).equals(tempStr)) {
                                tempAnswer.add(j+1);
                                break;
                            }
                        }
                        tempMsg = "";
                    }
                }
            }
        }

        answer = new int[tempAnswer.size()];
        for(int i=0; i<tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        return answer;
    }

}
