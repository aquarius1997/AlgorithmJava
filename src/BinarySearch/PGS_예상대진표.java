package BinarySearch;

/*
30min 0Fail
 */
public class PGS_예상대진표 {
    /**
     * 밑이 2인 log2(num)을 구한다
     * @param num
     * @return
     */
    public double base2_log(int num) {
        return Math.log10(num)/Math.log10(2);
    }

    /**
     * a와 b가 cnt번째에 만나는지 확인한다
     * @param cnt 라운드 수
     * @param a 비교할 참가자 1
     * @param b 비교할 참가자 2
     * @param start a와 b가 속한 구간의 첫번째 값
     * @param end a와 b가 속한 구간의 마지막 값
     * @return
     */
    public int bin_search(int cnt, int a, int b, int start, int end) {
        int mid = (start+end) / 2;
        //반으로 나눴을 때, 같은 구역에 있는지 없는지확인

        if(a <= mid && b > mid) {   //다른구역이면 현재n으로 리턴
            return cnt;
        } else if(a <= mid && b <= mid) {   //둘다 mid보다 작거나 같은 구역에 있으면
            return bin_search(cnt-1, a, b, start, mid);
        } else {    //둘다 mid보다 큰 구역에 있으면
            return bin_search(cnt-1, a, b, mid+1, end);
        }
    }

    public int solution(int n, int a, int b) {
        int answer = 0;
        int cnt = 0;    //몇번 대진해야 만나는지 저장

        cnt = (int)base2_log(n); //최댓값으로 초기화

        //a가 b보다 작은값으로 설정해서 함수를 호출한다
        if(a < b) {
            answer = bin_search(cnt, a, b, 1, n);
        } else {
            answer = bin_search(cnt, b, a, 1, n);
        }

        return answer;
    }
}
