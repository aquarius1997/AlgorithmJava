package DivideAndConquer;

public class PGS_점프와순간이동 {

    public int divCon(int n) {
        if(n == 1) { return 1; }
        else { return (divCon(n/2) + (n%2)); }
    }

    public int solution(int n) {
        int ans = 0;

        ans = divCon(n);

        return ans;
    }
}
