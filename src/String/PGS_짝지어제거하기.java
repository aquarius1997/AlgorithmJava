package String;

import java.util.LinkedList;
import java.util.Queue;

public class PGS_짝지어제거하기 {
    public int solution(String s) {
        int answer = 0;
        int[] arr = new int[1000001];   //짝지어져 제거되는 문자는 1로 저장한다
        Queue<Integer> q = new LinkedList<Integer>();   //확인할 범위 인덱스를 저장
        int cnt = 0;    //짝지어져 제거된 문자들의 수

        //가장 첫번째로 짝지어 지워질 문자쌍을 알아낸다
        for(int idx = 0; idx<s.length();) {
            if(idx+1 >= s.length()) { break; }
            if(s.charAt(idx) == s.charAt(idx+1)) {  //지울 문자 두개가 나타나면
                arr[idx] = arr[idx+1] = 1;  //제거된걸 표시하고
                q.add(idx); q.add(idx+1);   //탐색 범위를 나타내는 인덱스 2개를 큐에 삽입한다
                idx += 2;   //다음 짝지어 지워질 문자쌍을 알아내기 위해 인덱스 증가시키기
                cnt += 2;   //짝지어져 제거된 문자 수 카운팅해주기
            } else {    //지울 문자 아니면
                idx += 1;
            }
        }

        //(before+1)~(next-1) 범위에 해당하는 문자열은 이미 짝지어져 지워진 문자열들이다.
        int before, next;
        while(!q.isEmpty()) {
            before = q.poll() - 1;  //비교해야할 문자의 앞 인덱스
            next = q.poll() + 1;    //비교해야할 문자의 뒤 인덱스

            while(before >= 0) {    //문자열 범위를 벗어나지 않으면서
                if(arr[before] == 0) {  //비교해야할 문자의 앞 인덱스를 찾으면 루프 브레이크
                    break;
                } else {
                    before--;
                }
            }

            while(next < s.length()) {  //문자열 범위를 벗어나지 않으면서
                if(arr[next] == 0) {    //비교해야할 문자의 뒤 인덱스를 찾으면 루프 브레이크
                    break;
                } else {
                    next++;
                }
            }

            if(before >= 0 && next < s.length()) {  //문자열 범위를 벗어나지 않을 때
                if(s.charAt(before) == s.charAt(next)) {    //짝지어 제거되는 문자들일 경우
                    arr[next] = arr[before] = 1;    //지운거 표시하고
                    q.add(before);  //탐색 범위를 나타내는 인덱스 2개를 큐에 삽입한다
                    q.add(next);
                    cnt += 2;   //짝지어져 제거된 문자수를 카운팅한다
                }
            }

            //모든 문자열이 짝지어져 제거될 경우, 큐에 남은 요소를 확인할 필요가 없으므로 루프를 브레이크한다
            if(cnt == s.length()) { break; }

        }

        int flag = 0;   //문자열을 모두 제거할 수 있는지 표시하는 플래그
        for(int i=0; i<s.length(); i++) {
            if(arr[i] == 0) {   //문자열을 모두 제거할 수 없는 경우
                flag = 1;   break;
            }
        }

        //문자열을 모두 제거할 수 있는 경우
        if(flag == 0) {
            answer = 1;
        }

        return answer;
    }
}
