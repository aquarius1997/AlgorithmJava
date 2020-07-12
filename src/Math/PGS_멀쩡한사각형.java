package Math;

/**
 * 못풂
 * 체감난이도 : **********
 * 수학적으로 머리가 안돌아감.
 */
public class PGS_멀쩡한사각형 {

    public long getDividedCnt(int w, int h) {
        long returnValue = 1L;

        if(w == 1 && h == 1) {  //종료조건
            return returnValue;
        } else {
            if((w % 2 == 0) && (h % 2 == 0)) {  //둘 다 2로 나누어 떨어지면
                returnValue = 2L * getDividedCnt(w/2, h/2);
            } else if((w % 2 != 0) && (h % 2 != 0)) {   //둘 다 2로 나누어 떨어지지 않으면
                returnValue = 2L * getDividedCnt(w/2+1, h/2+1) - 1;
            } else {    //둘 중 하나만 나누어 떨어지지 않으면
                if(w % 2 != 0) {
                    returnValue = 2L *getDividedCnt(w/2+1, h/2);
                } else {
                    returnValue = 2L *getDividedCnt(w/2, h/2+1);
                }
            }
            return returnValue;
        }
    }

    public long solution(int w, int h) {
        long answer = (long)w*(long)h;

        answer -= getDividedCnt(w, h);

        return answer;
    }
}
