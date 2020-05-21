package BruteForce;

public class PGS_모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] per1 = new int[5];    int[] per2 = new int[8];    int[] per3 = new int[10];
        int per1Cnt, per2Cnt, per3Cnt;
        int per1Idx, per2Idx, per3Idx, answerIdx;
        int maxCnt = 0; int answerLen = 0;
        int i;

        per1Cnt = per2Cnt = per3Cnt = 0;
        per1Idx = per2Idx = per3Idx = answerIdx = 0;

        for(i=1; i<=5; i++) {
            per1[i-1] = i;
        }
        int num = 1;
        for(i=0; i<8; i++) {
            if(i % 2 == 0) { per2[i] = 2; }
            else {
                per2[i] = num;
                num++;
                if(num == 2) { num++; }
            }
        }

        for(i=0; i<2; i++) { per3[i] = 3; }
        for(i=2; i<4; i++) { per3[i] = 1; }
        for(i=4; i<6; i++) { per3[i] = 2; }
        for(i=6; i<8; i++) { per3[i] = 4; }
        for(i=8; i<10; i++) { per3[i] = 5; }

        for(i=0; i<answers.length; i++) {
            if(answers[i] == per1[per1Idx]) {
                per1Cnt++;
            }
            if(answers[i] == per2[per2Idx]) {
                per2Cnt++;
            }
            if(answers[i] == per3[per3Idx]) {
                per3Cnt++;
            }
            per1Idx++;
            if(per1Idx == per1.length) { per1Idx = 0;}
            per2Idx++;
            if(per2Idx == per2.length) { per2Idx = 0;}
            per3Idx++;
            if(per3Idx == per3.length) { per3Idx = 0;}

            if(maxCnt < per1Cnt) { maxCnt = per1Cnt; }
            if(maxCnt < per2Cnt) { maxCnt = per2Cnt; }
            if(maxCnt < per3Cnt) { maxCnt = per3Cnt; }
        }

        if(maxCnt == per1Cnt) {
            answerLen++;
        }
        if(maxCnt == per2Cnt) {
            answerLen++;
        }
        if(maxCnt == per3Cnt) {
            answerLen++;
        }

        answer = new int[answerLen];

        if(maxCnt == per1Cnt) {
            answer[answerIdx] = 1;  answerIdx++;
        }
        if(maxCnt == per2Cnt) {
            answer[answerIdx] = 2;  answerIdx++;
        }
        if(maxCnt == per3Cnt) {
            answer[answerIdx] = 3;  answerIdx++;
        }

        return answer;
    }
}
