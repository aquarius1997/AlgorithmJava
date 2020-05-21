package DFSandBFS;

/**
 * 13min. *, 0Fail
 */
public class PGS_타겟넘버 {
    int g_cnt = 0;

    public void make_target_num(int[] numbers, int target, int idx, int sum) {
        if(idx >= numbers.length) {        //확인해서카운팅
            if(sum == target) {
                g_cnt++;
            }
        } else {    //재귀호출
            make_target_num(numbers, target, idx+1, sum - numbers[idx]);
            make_target_num(numbers, target, idx+1, sum + numbers[idx]);
        }
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;

        make_target_num(numbers, target, 0, 0);

        answer = g_cnt;

        return answer;
    }
}
