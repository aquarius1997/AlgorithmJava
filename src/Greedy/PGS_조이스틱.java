package Greedy;

public class PGS_조이스틱 {
    public int solution(String name) {
        int[] visited;
        int answer = 0;
        int cnt = 0;    //원하는 알파벳을 만든 개수
        int idx = 0;    //현재 조이스틱의 위
        int upCnt, downCnt, leftCnt, rightCnt;
        int findFlag = 0;
        int leftIdx, rightIdx;
        int i;

        visited = new int[name.length()];   //조이스틱으로 원하는 알파벳으로 만들면 1로 저장한다. 초기 0

        for(i=0; i<name.length(); i++) {    //A로 만들려는 경우 처리
            if(name.charAt(i) == 'A') {
                visited[i] = 1;
                cnt++;
            }
        }

        while(true) {
            if(cnt == name.length()) { break; }

            upCnt = downCnt = leftCnt = rightCnt = 0;
            //1. 위 아래 중 더 이동 카운트가 작은걸 선택한다
            upCnt = name.charAt(idx) - 'A';
            downCnt = 'Z' - name.charAt(idx) + 1;
            if(upCnt < downCnt) {
                answer += upCnt;
            } else {
                answer += downCnt;
            }
            //2.원하는 알파벳으로 만듦을 처리
            visited[idx] = 1;
            if(upCnt * downCnt != 0) {
                cnt++;
            }

            //모든 원하는 알파벳을 만들면 while종료
            if(cnt == name.length()) {
                break;
            }


            //2. 왼쪽 오른쪽중 더 이동 카운트가 작은걸 선택한다 + 각각의 다음 확인 위치를 저장한다
            findFlag = 0;
            leftIdx = rightIdx = idx;
            //왼쪽 카운팅
            for(i=idx-1; i>=0; i--) {
                leftCnt++;
                if(visited[i] == 0) {
                    findFlag = 1;
                    leftIdx = i;
                    break;
                }
            }
            if(findFlag == 0) { //왼쪽으로 더 넘어가야할경우
                for (i = name.length() - 1; i > idx; i--) {
                    leftCnt++;
                    if (visited[i] == 0) {
                        leftIdx = i;
                        break;
                    }
                }
            }
            //오른쪽 카운팅
            findFlag = 0;
            for(i=idx+1; i<name.length(); i++) {
                rightCnt++;
                if(visited[i] == 0) {
                    findFlag = 1;   rightIdx = i;   break;
                }
            }
            if(findFlag == 0) { //오른ㅉ고으로 더 넘겨야할 경우
                for(i=0; i<idx; i++) {
                    rightCnt++;
                    if(visited[i] == 0) {
                        rightIdx = i;
                        break;
                    }
                }
            }
            //end 2

            //다음 이동 위치 지
            if(leftCnt < rightCnt) {
                answer += leftCnt;
                idx = leftIdx;
            } else {
                answer += rightCnt;
                idx = rightIdx;
            }
        }


        return answer;
    }
}
