package String;
import java.util.*;

public class No11720_숫자의합 {
    public static void main(String[] args) {
        String str;
        int strLen;
        int tempSum = 0;
        Scanner scanner = new Scanner(System.in);

        strLen = scanner.nextInt();
        str = scanner.next(); //문자열 입력

        for(int i=0; i<strLen; i++) {
            tempSum += (str.charAt(i) - '0');
        }

        System.out.println(tempSum);
    }

}
