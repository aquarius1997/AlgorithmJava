package 농심NDS;
import java.util.*;

public class Num2 {
    int[] visited;  //상자DFS 방문 여부 표시
    int maxCnt = 0;

    public void chooseBoxes(List<Integer> boxIdxList, int[] goods, int[] boxes, int cnt, int idx) {
        visited[idx] = 1;
        boxIdxList.add(idx);
        cnt += 1;

        if(cnt < goods.length) {    //DFS재귀
            for(int i=0; i<boxes.length; i++) {
                if(visited[i] == 0) {
                    chooseBoxes(boxIdxList, goods, boxes, cnt, i);
                }
            }
        } else {    //해당 상자들로 담을 수 있는 물건 몇개인지 확인
            int answerCnt = 0;
            for(int i=0; i<boxIdxList.size(); i++) {
                if(goods[i] <= boxes[(boxIdxList.get(i))]) {    //담을 수 있으면
                    answerCnt++;
                }
            }

            if(answerCnt > maxCnt) {    //갱신
                maxCnt = answerCnt;
            }
        }

        visited[idx] = 0;
        boxIdxList.remove(boxIdxList.size() - 1);
    }
    public int solution(int[] goods, int[] boxes){
        int answer = 0;
        visited = new int[boxes.length];

        for(int i=0; i<boxes.length; i++) {
            List<Integer> boxIdxList = new ArrayList<>();
            chooseBoxes(boxIdxList, goods, boxes, 0, i);
        }

        answer = maxCnt;

        return answer;
    }
}
