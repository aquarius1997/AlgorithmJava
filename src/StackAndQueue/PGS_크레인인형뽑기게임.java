package StackAndQueue;

import java.util.Stack;

/**
 * 20min
 * 체감난이도 : *
 * FailCnt : 0
 */
public class PGS_크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int friendsNum = 0;

        for(int j=0; j<moves.length; j++) {
            friendsNum = 0; //뽑힌 프렌즈가 없는 걸로 초기화
            for(int i=0; i<board.length; i++) { //크레인으로 프렌즈 뽑기
                if(board[i][moves[j]-1] != 0) {
                    friendsNum = board[i][(moves[j]-1)];
                    board[i][(moves[j]-1)] = 0;
                    break;
                }
            }

            if(friendsNum == 0) { continue; }   //잡힌 프렌즈가 없는 경우

            if(stack.empty()) { //비어있으면
                stack.push(friendsNum);
            } else {    //비어있지 않으면
                if(stack.peek() == friendsNum) {    //같은 프렌즈면
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(friendsNum);
                }
            }
        }

        return answer;
    }
}
