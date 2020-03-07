package String;
import java.util.*;

public class No10809_알파벳찾기 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int alphabetIdx[] = new int[26];    //[0] : a의 첫번째 인덱스, [1] : b ..., ...
        String str;
        int strLen;

        str = scanner.next();
        strLen = str.length();

        Arrays.fill(alphabetIdx, -1);    //alphabetIdx 배열을 모두 0으로 초기화

        for(int i=0; i<strLen; i++) {
            int alphabet = str.charAt(i) - 'a';
            if(alphabetIdx[alphabet] == -1) {
                alphabetIdx[alphabet] = i;
            }
        }

        for(int i=0; i<26; i++) {
            System.out.print(alphabetIdx[i] + " ");
        }
    }
}
