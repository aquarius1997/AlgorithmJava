package StackAndQueue;

class PGS_주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = {};
        int pricesLen = prices.length;
        int answerIdx = 0;
        int cnt = 0;
        int i, j;

        //answer배열 크기 지정
        answer = new int[pricesLen];

        //각 주식 가격에 대하여
        for(i=0; i<pricesLen; i++) {
            cnt = 0;
            for(j=i+1; j<pricesLen; j++) {
                cnt++;
                if(prices[j] < prices[i]) { //가격이 떨어지면
                    break;
                }
            }
            answer[answerIdx] = cnt;
            answerIdx++;
        }

        return answer;
    }
}