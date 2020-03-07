package String;
import java.util.*;

public class No1152_단어의개수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        int strLen;
        int cnt = 0;
        int flag = 0;   //문자가 오면 flag를 1로 변경

        str = scanner.nextLine();   //공백 포함 입력받기
        strLen = str.length();

        for(int i=0; i<strLen; i++) {
            char ch = str.charAt(i);
            if(ch == ' ') {
                flag = 0;
            } else {
                if(flag == 0) {
                    flag = 1;
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
