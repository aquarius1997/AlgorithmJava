package DynamicProgramming;

public class PGS_점프와순간이동 {
    public int solution(int n) {
        int ans = 0;
        int[]arr = new int[n+1];

        //base-case
        arr[0] = 0;
        arr[1] = 1;
        //induction step
        for(int i=2; i<=n; i++) {
            arr[i] = arr[(i/2)] + (i % 2);
        }

        ans = arr[n];

        return ans;
    }
}
