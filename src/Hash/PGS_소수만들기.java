package Hash;

import java.util.HashSet;
import java.util.LinkedList;

public class PGS_소수만들기 {
    HashSet<Integer> primes = new HashSet<Integer>();
    int g_primeCnt = 0;

    /**
     * 재귀호출 방식으로 3개의 숫자를 더하고, 더한 숫자가 소수인지 확인한다
     * @param nums 문제의 입력으로 주어진 숫자배열
     * @param idx 선택할 숫자의 인덱스
     * @param sum 함수호출 이전까지 누적된 숫자의 합
     * @param cnt 함수호출을 포함해서 선택한 숫자의 개수
     */
    public void add_3_nums(int[] nums, int idx, int sum, int cnt) {
        sum += nums[idx];

        if(cnt >= 3) {  //종료
            if(primes.contains(sum)) {  //소수이면
                g_primeCnt++;
            }
        } else {    //재귀호출
            for(int i=idx+1; i<nums.length; i++) {
                add_3_nums(nums, i, sum, cnt+1);
            }
        }
    }

    public int solution(int[] nums) {
        int answer = -1;
        LinkedList<Integer> tempPrimes = new LinkedList<Integer>();
        int sqrtN = 0;
        int primeFlag = 0;
        int i = 0;

        tempPrimes.add(2);
        primes.add(2);
        //1. 소수들을 만들어서 HashSet에 저장
        for(int num=3; num<50000; num++) {
            sqrtN = (int)Math.sqrt(num);
            primeFlag = 0;  //소수가 아니면 1
            for(i=0; i<tempPrimes.size(); i++) {
                if(tempPrimes.get(i) > sqrtN) { break; }
                if(num % tempPrimes.get(i) == 0) {  //소수아님
                    primeFlag = 1;  break;
                }
            }
            if(primeFlag == 0) {    //소수일경우
                tempPrimes.add(num);
                primes.add(num);
            }
        }

        //3개의 수를 더하는 함수를 호출한다
        for(i=0; i<nums.length; i++) {
            add_3_nums(nums, i, 0, 1);
        }

        answer = g_primeCnt;

        return answer;
    }
}
