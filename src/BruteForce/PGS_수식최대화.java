package BruteForce;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 소요시간 : 1h10min + 30min
 * FailCnt : 0
 * 체감난이도 : *****
 * 처음에 문제에서 주어진 예제 TC가 ArrayIndexOutOfBoundsException이 발생
 * 문제가 무엇일지 디버깅하느라 거의 50분씀
 * 예외가 발생하던 이유는 LinkedList의 remove 메소드를 호출하면 요소가 아예 리스트에서 삭제되고 따라서 삭제 이전의 인덱스와 달라진다는 것을 자꾸 배열에서 값 삭제로
 * 착각해서 일어났던 것임
 */
public class PGS_수식최대화 {
    ArrayList<String> g_opList = new ArrayList<String>();   //expression에 사용된 연산자를 저장(중복제외. 우선순위 정할 용도)
    ArrayList<Long> g_numberList = new ArrayList<Long>(); //expression에 있는 숫자들 저장
    ArrayList<String> g_operator = new ArrayList<String>();   //expression에 있는 연산자들
    ArrayList<String> g_op = new ArrayList<String>(); //연산자 우선순위
    LinkedList<Long> g_number = new LinkedList<Long>();   //계산할 때 사용할 숫자들
    LinkedList<String> g_operatorTemp = new LinkedList<String>();   //계산할 때 사용할 연산자들

    int[] visited;  //연산자 순열 만들 때, 이미 조합에 추가된 경우 1로 저장
    long maxNum = 0;

    public void get_maxNum() {
        long num = 0;
        for(int i=0; i<g_op.size(); i++) {  //연산자 우선순위대로
            for(int j=0;;) {
                if(j >= g_operatorTemp.size()) { break; }
                if(g_op.get(i).equals(g_operatorTemp.get(j))) { //탐색하려는 우선순위에 해당하는 연산자 찾으면
                    num = g_number.get(j);
                    if(g_op.get(i).equals("+")) {
                        num += g_number.get(j+1);
                    } else if(g_op.get(i).equals("-")) {
                        num -= g_number.get(j+1);
                    } else {
                        num *= g_number.get(j+1);
                    }

                    //계산에 활용한 숫자들 제거하고
                    g_number.remove(j);
                    g_number.remove(j);     //!!처음에 g_number.remove(j+1);
                    //계산한 숫자 해당 위치에 삽입
                    g_number.add(j, num);

                    //계산에 사용한 연산자 삭제
                    g_operatorTemp.remove(j);
                } else {
                    j++;
                }
            }
        }

        //정답찾기
        num = g_number.get(0);
        if(num < 0) {   //음수면 절댓값으로
            num *= -1L;
        }
        if(num > maxNum) { maxNum = num; }
        g_number.remove(0);
    }

    public void get_op_cases(int idx, int cnt) {    //cnt : 1로 call
        visited[idx] = 1;
        g_op.add(g_opList.get(idx));

        if(cnt < g_opList.size()) {
            for(int i=0; i<g_opList.size(); i++) {
                if(visited[i] == 0) {
                    get_op_cases(i, cnt+1);
                }
            }
        } else {    //연산자 순열 만들면
            for(int i=0; i<g_numberList.size(); i++) {  //숫자 초기화
                g_number.add(g_numberList.get(i));
            }
            for(int i=0; i<g_operator.size(); i++) {    //연산자 초기화
                g_operatorTemp.add(g_operator.get(i));
            }
            //함수호출
            get_maxNum();

            g_number.clear();;
            g_operatorTemp.clear();

        }

        visited[idx] = 0;
        g_op.remove((g_op.size()-1));
    }

    public long solution(String expression) {
        long answer = 0;
        int[] opFlag = new int[3];   //int[0]=1 : +가 있으면1, [1]=1 : -가 있으면 1, [2]=1 : *이 있으면 1

        //expression에 사용된 연산자 알아내기 + 숫자 알아내기
        int tempNum = -1;
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {    //숫자
                if(tempNum == -1) { //첫번째로 나온 숫자이면
                    tempNum = expression.charAt(i) - '0';
                } else {
                    tempNum *= 10;
                    tempNum += expression.charAt(i) - '0';
                }
            } else {    //연산자
                g_numberList.add((long)tempNum);
                tempNum = -1;

                if(expression.charAt(i) == '+') {
                    g_operator.add("+");
                    opFlag[0] = 1;
                } else if(expression.charAt(i) == '-') {
                    g_operator.add("-");
                    opFlag[1] = 1;
                } else if(expression.charAt(i) == '*') {
                    g_operator.add("*");
                    opFlag[2] = 1;
                }
            }
        }
        g_numberList.add((long)tempNum);

        //사용된 연산자로 ArrayList만들기
        if(opFlag[0] == 1) g_opList.add("+");
        if(opFlag[1] == 1) g_opList.add("-");
        if(opFlag[2] == 1) g_opList.add("*");

        visited = new int[3];

        for(int i=0; i<g_opList.size(); i++) {
            get_op_cases(i, 1);
        }

        answer = maxNum;

        return answer;
    }
}
