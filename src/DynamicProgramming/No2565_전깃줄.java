package DynamicProgramming;

import java.util.*;

public class No2565_전깃줄 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[502];
        int[] incLIS = new int[502];    //i번째 전기줄을 포함했을 때 LIS를 구한다
        int N, a, b;
        int maxNum = 0;
        int incMAX;

        Arrays.fill(arr, 0);
        Arrays.fill(incLIS, 0);

        N = scanner.nextInt();

        for(int i=1; i<=N; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            arr[a] = b;
        }

        //LIS구하기
        //base case
        int i = 1;
        while(arr[i] == 0) {
            incLIS[i] = 0;
            i++;
        }
        incLIS[i] = 1;  i++;
        //induction step
        for(; i<=500; i++) {
            maxNum = 0;
            if(arr[i] == 0) {
                incLIS[i] = incLIS[i-1];
                continue;
            }
            for(int j=i-1; j>=1; j--) {
                if (arr[i] > arr[j] && arr[j] != 0) {
                    if (incLIS[j] > maxNum) {
                        maxNum = incLIS[j];
                    }
                }
            }
            incLIS[i] = 1 + maxNum;
        }

        maxNum = 0;
        for(i=1; i<=500; i++) {
            if(maxNum < incLIS[i]) {
                maxNum = incLIS[i];
            }
        }

        System.out.println(N-maxNum);
    }
}
