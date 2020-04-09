package StackAndQueue;

import java.util.LinkedList;

class PGS_프린터 {
    public int solution(int[] priorities, int location) {
        LinkedList<Integer> priorityQueue = new LinkedList<Integer>();  //우선순위 저장 큐
        LinkedList<Integer> indexQueue = new LinkedList<Integer>(); //문서 번호 저장 큐
        int answer = 1;
        int j = -1; //이미 꺼낸 문
        int existFlag = 0;
        int i;

        //priorities와 원래 요소들의 위치 큐에 삽입
        for(i=0; i<priorities.length; i++) {
            priorityQueue.add(priorities[i]);
            indexQueue.add(i);
        }

        //인쇄시작
        while(true) {
            int priority = priorityQueue.get(0);   //첫번째 요소의
            j = indexQueue.get(0);   //
            existFlag = 0;  //j보다 우선순위가 큰게 있으면 1로 변경
            //우선순위 큰게 있는지 확인
            for(i=1; i<priorityQueue.size(); i++) {
                if(priorityQueue.get(i) > priority) {
                    existFlag = 1; break;
                }
            }
            //우선순위 큰게 있으면
            if(existFlag == 1) {
                //맨 앞의 요소를 지우고 맨 뒤로 이
                priorityQueue.remove(0);
                indexQueue.remove(0);
                priorityQueue.add(priority);
                indexQueue.add(j);
            } else {    //없으면 출력
                priorityQueue.remove(0);
                indexQueue.remove(0);
                if(j == location) { //구하려는 문서였으면
                    break;
                }
                answer += 1;
            }
        }

        return answer;
    }
}