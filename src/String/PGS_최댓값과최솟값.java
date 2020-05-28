package String;

public class PGS_최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        int flag = 0;   //공백일경우 0, 숫자 시작시 1
        int minusFlag = 0;  //음수일경우 1
        int tempNum = 0;
        int firstNum = 0;   //첫번째 숫자가 아니면 1
        int minNum, maxNum;

        minNum = maxNum = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') {
                if(minusFlag == 1) {    //음수일경우 -1을 곱해준다
                    tempNum *= -1;
                }
                if(firstNum == 0) { //첫번째로 구한 숫자이면
                    maxNum = minNum = tempNum;
                    firstNum = 1;
                } else {    //첫번째로 구한 숫자가 아니면 최댓값과 최솟값을 업데이트할수있는지 확인
                    if(tempNum > maxNum) { maxNum = tempNum; }
                    if(tempNum < minNum) { minNum = tempNum; }
                }
                flag = minusFlag = 0;
            } else {    //공백이 아닌 경우
                if(flag == 1) {
                    tempNum = (tempNum * 10) + (s.charAt(i) - '0');
                } else {    //숫자 시작
                    if(s.charAt(i) == '-') {    //음수로 표현해야할 경우
                        minusFlag = 1;
                    } else {    //숫자 시작
                        tempNum = s.charAt(i) - '0';
                        flag = 1;
                    }
                }
            }
        }

        //마지막 값
        if(minusFlag == 1) {    //음수일경우 -1을 곱해준다
            tempNum *= -1;
        }
        if(tempNum > maxNum) { maxNum = tempNum; }
        if(tempNum < minNum) { minNum = tempNum; }

        answer += minNum;
        answer += " ";
        answer += maxNum;

        return answer;
    }
}
