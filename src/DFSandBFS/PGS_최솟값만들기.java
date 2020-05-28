package DFSandBFS;

import java.util.Arrays;

public class PGS_최솟값만들기 {
    public int solution(int []A, int []B) {
        int answer = 0;
        int bLen = B.length;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length; i++) {
            answer += (A[i] * B[bLen-1-i]);
        }

        return answer;
    }
}
