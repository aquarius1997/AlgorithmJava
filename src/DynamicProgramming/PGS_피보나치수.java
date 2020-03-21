package DynamicProgramming;

/**
 * 별(*)
 */
class PGS_피보나치수 {
    public int solution(int n) {
        int[] fibo = new int[100002];
        int answer = 0;

        fibo[0] = 0;
        fibo[1] = 1;

        for(int i=2; i<=n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
            fibo[i] = fibo[i] % 1234567;
        }

        answer = fibo[n];
        return answer;
    }
}