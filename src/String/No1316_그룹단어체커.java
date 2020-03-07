package String;
import java.util.*;

public class No1316_그룹단어체커 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N;
        int cnt = 0;

        N = scanner.nextInt();
        for(int i=0; i<N; i++) {
            String str = scanner.next();
            int alphabet[] = new int[26];
            Arrays.fill(alphabet, -1);   //알파벳 a 그룹의 마지막 인덱스 저장
            int flag = 0;   //그룹단어 아니면 1

            for(int j=0; j<str.length(); j++) {
                int alpha = str.charAt(j) - 'a';
                if(alphabet[alpha] == -1) {  //첫번째로 등장했으면 인덱스 그냥 저장
                    alphabet[alpha] = j;
                } else {
                    if(alphabet[alpha] == j-1) {//이전 인덱스도 나와 동일할 경우에만 그루핑 가능
                        alphabet[alpha] = j;
                    } else {    //그룹만들수 없음
                        flag = 1;
                        break;
                    }
                }
            }

            if(flag == 0) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
