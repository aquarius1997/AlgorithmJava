package BinarySearch;

public class PGS_예산 {
    int maxBudget = 0;

    public void bin_search(int[] budgets, int M, int start,  int end) {
        long sum = 0;
        int mid = (start + end) / 2;
        int i;

        if(start < end) {
            if(start + 1 == end) {  //종료
                maxBudget = start;  return;
            }
            //현재 start값으로 예산의 총 합을 얼마나 줄 수 있을지 구한다
            for(i=0; i<budgets.length; i++) {
                if(budgets[i] >= mid) {
                    sum += mid;
                } else {
                    sum += budgets[i];
                }
            }
            //구한 예산의 총합이 M보다 크면 못줌
            if(sum > M) {
                bin_search(budgets, M, start, mid);
            } else {    //구한 예산의 총합이 M보다 작으면 더 큰범위에서 찾는다
                if(mid > maxBudget) { maxBudget = mid;}
                bin_search(budgets, M, mid, end);
            }
        }
    }

    public int solution(int[] budgets, int M) {
        int answer = 0; int max = 0;
        long sum = 0;
        int i;

        for(i=0; i<budgets.length; i++) {
            sum += budgets[i];
            if(max < budgets[i]) { max = budgets[i];}
        }

        if(sum <= M) {
            answer = max;
        } else {
            bin_search(budgets, M, 0, M);

            answer = maxBudget;
        }

        return answer;
    }
}
