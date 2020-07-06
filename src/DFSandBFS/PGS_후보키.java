package DFSandBFS;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * 체감난이도 : ******
 * 문제의 최소성 조건을 제대로 이해 못해서 그거 이해하느라 하루종일 걸림
 */
public class PGS_후보키 {
    int recordN = 0;
    int attrN = 0;
    int candidateKeyN = 0;
    LinkedList<HashSet<Integer>> setList = new LinkedList<HashSet<Integer>>();
    int[] visited;

    /**
     * 유일성을 만족하는 속성 세트인지 확인한다
     * @param relation
     * @param idx
     * @param totalCnt
     * @param cnt
     */
    public void check_unique(String[][] relation, int idx, int totalCnt, int cnt) {
        visited[idx] = 1;

        if(totalCnt == cnt) {
            String tempStr = "";
            int flag = 0;   //유일성 만족 못하면 1
            HashSet<String> keySet = new HashSet<String>();

            for(int i=0; i<recordN; i++) {
                tempStr = "";
                for(int j=0; j<attrN; j++) {
                    if(visited[j] == 1) {
                        tempStr += relation[i][j];
                        tempStr += ":";
                    }
                }

                if(keySet.contains(tempStr)) {
                    flag = 1;
                } else {
                    keySet.add(tempStr);
                }
            }

            if(flag == 0) { //유일성 만족하는 속성세트임
                HashSet<Integer> attrSet = new HashSet<Integer>();
                for(int i=0; i<attrN; i++) {
                    if(visited[i] == 1) {
                        attrSet.add(i);
                    }
                }
                //유일성 만족하는 속성 세트들을 저장하는 리스트에 add
                setList.add(attrSet);
            }
        } else {
            for(int i=idx+1; i<attrN; i++) {
                check_unique(relation, i, totalCnt, cnt+1);
            }
        }

        visited[idx] = 0;
    }

    /**
     * 최소성을 만족하는 속성 세트인지 확인한다
     */
    public void check_minimal() {
        int[] minimalFlagArr = new int[setList.size()];

        for(int i=0; i<setList.size(); i++) {
            if(minimalFlagArr[i] == -1) { continue; }
            for(int j=i+1; j<setList.size(); j++) {
                if(setList.get(j).containsAll(setList.get(i))) {    //i번째 set이 j번째 set의 부분집합이면
                    minimalFlagArr[j] = -1; //최소성 만족 못
                }
            }
        }

        for(int i=0; i<setList.size(); i++) {
            if(minimalFlagArr[i] != -1) {   //후보키
                candidateKeyN++;
            }
        }
    }

    public int solution(String[][] relation) {
        int answer = 0;

        candidateKeyN = 0;
        recordN = relation.length;
        attrN = relation[0].length;
        visited = new int[attrN];

        for(int totalCnt = 1; totalCnt<= attrN; totalCnt++) {
            for(int i=0; i<attrN; i++) {
                check_unique(relation, i, totalCnt, 1);
            }
        }

        check_minimal();

        answer = candidateKeyN;

        return answer;
    }
}
