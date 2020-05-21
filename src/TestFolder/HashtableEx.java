package TestFolder;

import java.util.Hashtable;
import java.util.Scanner;

public class HashtableEx {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();

        hashtable.put("apple", "123");
        hashtable.put("grape", "1234");
        hashtable.put("strawberry", "12345");

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("아이디와 비밀번호 입력하세요");
            System.out.print("아이디 : ");
            String id = scanner.nextLine();

            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();

            if (hashtable.containsKey(id)) {
                if (hashtable.get(id).equals(password)) {
                    System.out.println("로그인 되었습니다.");
                    break;
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
            } else {
                System.out.println("아이디가 존재하지 않습니다.");
            }
        }
    }
}
