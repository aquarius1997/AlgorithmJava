package DFSandBFS;

/**
 * 23min, ***
 */
public class PGS_단어변환 {
    int minCnt = 0;
    int[] visited;

    public void dfs_search(String preString, String target, String[] words, int index, int cnt) {
        int diffCnt = 0;
        int i, j;

        visited[index] = 1;

        //변경완료
        if(target.equals(words[index])) {
            if(minCnt > cnt) {
                minCnt = cnt;
            }
            visited[index] = 0;

            return;
        }

        //1.하나의 알파만 다른 경우 방문한다
        for(i=0; i<words.length; i++) {
            diffCnt = 0;

            for(j=0; j<preString.length(); j++) {
                if(preString.charAt(j) != words[i].charAt(j)) {
                    diffCnt++;
                }
                //두개 이상 다르면 확인할 필요 없음
                if(diffCnt > 2) { break; }
            }

            //1개의 알파벳만 바꿀 수 있을 경우 방문 안했으면 방문한다
            if(diffCnt == 1 && visited[i] == 0) {
                dfs_search(words[i], target, words, i, cnt+1);
            }
        }
        //end 1


        visited[index] = 0;
    }

    public int solution(String begin, String target, String[] words) {
        final int canNot = 98798987;
        int answer = 0;
        int i, j;


        //1. 변환할 수 없는 경우 flag 는 0일것이다
        int flag = 0;
        for(i=0; i<words.length; i++) {
            if(target.equals(words[i])) {
                flag = 1;
            }
        }

        //2. 변환 가능한 경우 DFS탐색으로 최단 변경을 알아내자
        if(flag == 1) {
            minCnt = canNot;  //최대로 저장
            visited = new int[words.length];

            //글자 하나만 다른거 방문하기
            int diffCnt;

            for(i=0; i<words.length; i++) {
                diffCnt = 0;

                for(j=0; j<begin.length(); j++) {
                    if(begin.charAt(j) != words[i].charAt(j)) {
                        diffCnt++;
                    }
                    //두개 이상 다르면 확인할 필요 없음
                    if(diffCnt > 2) { break; }
                }

                //1개의 알파벳만 바꿀 수 있을 경우 방문 안했으면 방문한다
                if(diffCnt == 1 && visited[i] == 0) {
                    dfs_search(words[i], target, words, i, 1);
                }
            }

            if(minCnt != canNot) {
                answer = minCnt;
            }
        }
        return answer;
    }
}
