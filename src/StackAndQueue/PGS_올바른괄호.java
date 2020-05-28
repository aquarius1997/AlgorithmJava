package StackAndQueue;

import java.util.Stack;

public class PGS_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if(stack.size() == 0) {
                    answer = false; break;
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.size() != 0) {
            answer = false;
        }

        return answer;
    }
}
