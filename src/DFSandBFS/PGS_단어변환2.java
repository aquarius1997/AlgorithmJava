package DFSandBFS;

/**
 * 체감난이도 : ***
 * FailCnt : 0
 * 소요시간 : 15min
 */
public class PGS_단어변환2 {
    final int CANT = 987987987;
    int minCnt = CANT;
    int[] visited;

    public void changeChar(String[] words, String preStr, String target, int cnt) {
        if(preStr.equals(target)) { //최소 횟수로 변경할 수 있는지 업데이트
            if(minCnt > cnt) {
                minCnt = cnt;
            }
        }

        if(words.length == cnt) return; //더이상 탐색할 거 없음

        int diffCnt = 0;    //다른 문자의 개수를 센다
        for(int i=0; i<words.length; i++) {
            diffCnt = 0;
            //몇개의 문자가 다른지 비교
            for(int j=0; j<preStr.length(); j++) {
                if(preStr.charAt(j) != words[i].charAt(j)) {
                    diffCnt++;
                }
                if(diffCnt >= 2) { break; }
            }

            //하나만 바꿀 수 있고 이미 방문 안했던 노드이면 DFS
            if(diffCnt == 1 && visited[i] == 0) {
                visited[i] = 1;
                changeChar(words, words[i], target, cnt+1);
                visited[i] = 0;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        visited = new int[words.length];    //방문하면 1

        changeChar(words, begin, target, 0);

        if(minCnt == CANT) {
            answer = 0;
        } else {
            answer = minCnt;
        }

        return answer;
    }
}
