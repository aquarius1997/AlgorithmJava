package StackAndQueue;

public class PGS_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int[] tempAnswer = new int[102];
        int[] days = new int[102];  //progresses에 있는 작업들 각각 기능 개발이 완료되기 까지 걸리는 날짜
        int daysIdx = 0;    int answerIdx = 0;
        int idx = 0;
        int cnt = 0;
        int i, j;

        //각 기능개발에 몇일이 걸리는지 계산한다
        for(i=0; i<progresses.length; i++) {
            int restNum = (100 - progresses[i]) % speeds[i];    //나눠서 떨어지는지 확인하기 위해
            int dayCnt = 0;

            if (restNum == 0) {  //나누어 떨어지몀ㄴ
                dayCnt = (100 - progresses[i]) / speeds[i];
            } else { //나누어 떨어지지 않으면
                dayCnt = (100 - progresses[i]) / speeds[i] + 1;
            }
            //배열에 저장
            days[daysIdx] = dayCnt;
            daysIdx++;
        }

        //기능 완료 순서대로 몇개씩 배포 가능한지 알아낸다
        for(idx=0; idx<daysIdx;) {
            cnt = 0;
            for (j = idx; j < daysIdx; j++) {
                if (days[idx] >= days[j]) {  //같이 기능개발을 끝낼 수 있으면
                    cnt++;
                } else {
                    break;
                }
            }

            tempAnswer[answerIdx] = cnt;
            answerIdx++;
            idx += cnt;
        }

        answer = new int[answerIdx];
        for(i=0; i<answerIdx; i++) {
            answer[i] = tempAnswer[i];
        }

        return answer;
    }
}
