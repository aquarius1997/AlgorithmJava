package DivideAndConquer;

public class PGS_행렬의곱셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer;

        answer = new int[arr1.length][arr2[0].length];

        for(int i=0; i<arr1.length; i++) {
            for(int j=0; j<arr2[0].length; j++) {
                multiple(arr1, arr2, answer, i, j);
            }
        }

        return answer;
    }

    public void multiple(int[][] arr1, int [][]arr2, int answer[][], int row, int col) {
        int temp = 0;

        for(int i=0; i<arr1[row].length; i++) {
            temp += (arr1[row][i] * arr2[i][col]);
        }

        answer[row][col] = temp;
    }
}
