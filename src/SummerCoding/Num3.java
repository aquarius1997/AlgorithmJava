package SummerCoding;

public class Num3 {
    public long solution(long n) {
        long answer = 0;
        int cnt = 1;
        int x = 0;

        //몇개씩 끊을지 확인
        while(n > cnt) {
            cnt = cnt + 1 + cnt;
            if(n <= cnt) { break; }
            x++;
        }

        

        return answer;
    }
}
