package String;

import java.util.Stack;

public class PGS_괄호변환 {

    public String makeCorrectStr(String p) {
        int openCnt, closeCnt;
        String u, v;

        u = ""; v = "";
        openCnt = closeCnt = 0;

        if(p == "") {
            return "";
        } else {
            //2. u,v 분리
            if(p.charAt(0) == '(') { openCnt++; }
            else { closeCnt++; }
            for(int i=1; i<p.length(); i++) {
                if(p.charAt(i) == '(') { openCnt++; }
                else { closeCnt++; }
                //균형잡힌 괄호 문자열로 더이상 분리할 수 없는 경우
                if(openCnt == closeCnt) {
                    u = p.substring(0, i+1);
                    if(i+1 < p.length()) {
                        v = p.substring(i+1, p.length());
                    } else {
                        v = "";
                    }
                    break;
                }
            }

            //3. u가 올바른 괄호 문자열인지 확인
            Stack<Character> stack = new Stack<Character>();
            int flag = 0;   //올바른 괄호 문자열이 아니면 1로 저장
            for(int i=0; i<u.length(); i++) {
                if(u.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if(stack.size() == 0) {
                        flag = 1;   break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(stack.size() != 0) {
                flag = 1;
            }
            System.out.println("u : " + u + ", flag : " + flag);

            if(flag == 0) { //올바른 괄호 문자열이면
                String returnedStr = makeCorrectStr(v);
                return u+returnedStr;
            } else {    //올바른 괄호 문자열이 아니면
                String tempStr = "(";   //반환시킬 문자열
                String returnedStr = makeCorrectStr(v);
                tempStr += returnedStr;
                tempStr += ")";
                String changedU = "";

                //4-4. u의 첫번째와 마지막 문자를 제거하고 나머지 문자열의 괄호를 뒤집는다
                u = u.substring(1, u.length()-1);
                for(int i=0; i<u.length(); i++) {
                    if(u.charAt(i) == '(') {
                        changedU += ')';
                    } else {
                        changedU += '(';
                    }
                }

                tempStr += changedU;
                return tempStr;
            }
        }

    }

    public String solution(String p) {
        String answer = "";

        answer = makeCorrectStr(p);

        return answer;
    }
}
