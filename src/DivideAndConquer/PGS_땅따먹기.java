package DivideAndConquer;

public class PGS_땅따먹기 {
    int solution(int[][] land) {
        int answer = 0;
        int[][] maxSum = new int[100001][4];
        int max = 0;

        //base-case
        for(int j=0; j<4; j++) {
            maxSum[0][j] = land[0][j];
        }

        //induction step
        for(int i=1; i<land.length; i++) {
            if(maxSum[i-1][1] > maxSum[i-1][2]) { max = maxSum[i-1][1]; } else { max = maxSum[i-1][2]; }
            if(maxSum[i-1][3] > max) { max = maxSum[i-1][3]; }
            maxSum[i][0] = land[i][0] + max;

            if(maxSum[i-1][0] > maxSum[i-1][2]) { max = maxSum[i-1][0]; } else { max = maxSum[i-1][2]; }
            if(maxSum[i-1][3] > max ) { max = maxSum[i-1][3]; }
            maxSum[i][1] = land[i][1] + max;

            if(maxSum[i-1][0] > maxSum[i-1][1]) { max = maxSum[i-1][0]; } else { max = maxSum[i-1][1]; }
            if(maxSum[i-1][3] > max) { max = maxSum[i-1][3]; }
            maxSum[i][2] = land[i][2] + max;

            if(maxSum[i-1][0] > maxSum[i-1][1]) { max = maxSum[i-1][0]; } else { max = maxSum[i-1][1]; }
            if(maxSum[i-1][2] > max) { max = maxSum[i-1][2]; }
            maxSum[i][3] = land[i][3] + max;

            for(int j=0; j<4; j++) {
                System.out.print(maxSum[i][j] + " ");
            }
            System.out.println();
        }

        //가장 큰 땅따먹기 수 구하기
        int lastRow = land.length - 1;
        max = maxSum[lastRow][0];
        for(int j=1; j<4; j++) {
            if(maxSum[lastRow][j] > max) {
                max = maxSum[lastRow][j];
            }
        }

        answer = max;

        return answer;
    }
}
