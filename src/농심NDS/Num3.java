package 농심NDS;

import java.util.*;

/**
 *
 */
public class Num3 {
    public class Coffee implements Comparable<Coffee>{
        int orderNum;  //커피 주문 번호
        int times;  //완료시

        public Coffee(int orderNum, int times) {
            this.orderNum = orderNum;
            this.times = times;
        }

        @Override
        public int compareTo(Coffee coffee) {  //만드는 시간이 짧을수록 우선순위 높게, 시간이 동일하면 커피 주문번호가 작은게 우선순위 높게
            if(this.times > coffee.times) {
                return 1;
            } else if(this.times == coffee.times) {
                if(this.orderNum > coffee.orderNum) {
                    return 1;
                } else if(this.orderNum == coffee.orderNum) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }

    public int[] solution(int N, int[] coffee_times) {
        int[] answer = {};

        answer = new int[coffee_times.length];  int answerIdx=0;
        TreeSet<Coffee> treeSet = new TreeSet<>();
        int coffeeIdx = 0;

        for(int i=0; i<N; i++) {
            if(coffeeIdx >= coffee_times.length) break;
            treeSet.add(new Coffee(coffeeIdx, coffee_times[coffeeIdx]));
            coffeeIdx++;
        }

        int sec = 0;
        while(!treeSet.isEmpty()) {
            Coffee coffee = treeSet.pollFirst();
            answer[answerIdx] = coffee.orderNum+1;
            answerIdx++;
            sec = coffee.times;

            if(coffeeIdx < coffee_times.length) {
                if(treeSet.size() >= N) break;

                treeSet.add(new Coffee(coffeeIdx, coffee_times[coffeeIdx] + sec));
                coffeeIdx++;
            }
        }


        return answer;
    }
}
