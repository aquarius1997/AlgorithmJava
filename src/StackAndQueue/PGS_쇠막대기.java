package StackAndQueue;

public class PGS_쇠막대기 {
    public int solution(String arrangement) {
        int[] stackType = new int[50100];
        int stackTop = -1;
        int laserNum = 0;
        int answer = 0;
        int i;

        for(i=0; i<arrangement.length(); i++) {
            if(arrangement.charAt(i) == '(') {  //push
                laserNum++;
                stackType[++stackTop] = laserNum;
            } else {
                if(laserNum == stackType[stackTop]) { //laser
                    stackTop -= 1;  //pop
                    answer += (stackTop + 1);   //스택 요소 개수만큼 더하기
                } else {    //laser 아니면 +1
                    stackTop -= 1;  //pop
                    answer += 1;
                }
            }
        }


        return answer;
    }


}
