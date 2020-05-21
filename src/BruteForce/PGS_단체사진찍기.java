package BruteForce;

public class PGS_단체사진찍기 {
    int[] g_location = new int[10]; //순서대로 A, C, F, J, M, N, R, T 가 서 있는 위치를 저장한다
    int[] g_visited = new int[10];  //A, C, F, J, M, N, R, T 순서대로 방문 여부를 저장한다 (1:방문, 0:방문안함)
    int g_cnt = 0;  //조건을 만족하는 수를 카운팅

    /**
     * DFS를 사용해 완전탐색
     * @param idx 현재 탐색 인덱스
     * @param nth 몇번째에 세울건지
     * @param cnt 줄 세운 카카오프렌즈의 수
     */
    public void dfs_search(int idx, int nth, int cnt, int n, String[] data) {
        int i, index;
        int tempDist;
        char tempChar;  int charNum = 0;
        int from, to, dist;
        int flag = 0;
        from = to = dist = 0;

        g_visited[idx] = 1;
        g_location[idx] = nth;

        for(i=0; i<8; i++) {
            if(g_visited[i] == 0) { //방문 안한 사람은
                dfs_search(i, nth+1, cnt+1, n, data);
            }
        }

        g_visited[idx] = 0;

        if(cnt == 8) {  //모두 줄 세운 경우 조건을 만족하는지 확인한다

            for(i=0; i<n; i++) {

                index = 0;
                //조건을 제시한 프렌즈와 상대방 프렌즈의 인덱스를 구한다
                while(true) {
                    tempChar = data[i].charAt(index);

                    switch(tempChar) {
                        case 'A' : charNum = 0; break;
                        case 'C' : charNum = 1; break;
                        case 'F' : charNum = 2; break;
                        case 'J' : charNum = 3; break;
                        case 'M' : charNum = 4; break;
                        case 'N' : charNum = 5; break;
                        case 'R' : charNum = 6; break;
                        case 'T' : charNum = 7; break;
                        default: break;
                    }

                    if(index == 2) { to = charNum; break; } //상대방
                    else { from = charNum; index = 2; } //조건 제시 프렌즈
                }

                dist = data[i].charAt(4) - '0';

                //둘 사이의 거리를 구한다
                tempDist = g_location[from] - g_location[to];
                if(tempDist < 0) { tempDist *= -1; }
                tempDist -= 1;

                //조건을 만족하지 않으면 다음 조건을 확인하지 않고 루프를 나간다
                if(data[i].charAt(3) == '=') {
                    if(!(tempDist == dist)) { flag = 1; break; }
                } else if(data[i].charAt(3) == '>') {
                    if(!(tempDist > dist)) { flag = 1; break; }
                } else {
                    if(!(tempDist < dist)) { flag = 1; break; }
                }

            }   //end for(i)

            if(flag == 0) { //조건 만족
                g_cnt++;
            }
        }
    }

    public int solution(int n, String[] data) {
        int answer = 0;

        for(int i=0; i<8; i++) {
            dfs_search(i, 1, 1, n, data);
        }

        answer = g_cnt;

        return answer;
    }

}
