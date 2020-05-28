package StackAndQueue;

import java.util.Stack;

public class PGS_짝지어제거하기 {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();

        stack.push(s.charAt(0));
        for(int idx=1; idx<s.length(); idx++) {
            if(stack.empty()) {
                stack.push(s.charAt(idx));
            } else {
                if(stack.peek() == s.charAt(idx)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(idx));
                }
            }
        }

        if(stack.isEmpty()) { answer = 1;}

        return answer;
    }
}
