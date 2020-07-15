package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class No12865_평범한배낭 {
    public static class Stuff implements Comparable<Stuff> { //물건 클래스
        int w;  //무게
        int v;  //가치

        public Stuff(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Stuff stuff) {
            if(this.v < stuff.v) return 1;
            else if(this.v == stuff.v) return 0;
            else return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        //배낭 정보 입력받기
        ArrayList<Stuff> stuffs = new ArrayList<Stuff>();
        int w, v;
        for(int i=0; i<N; i++) {
            w = scanner.nextInt();
            v = scanner.nextInt();
            stuffs.add(new Stuff(w, v));
        }

        ArrayList<ArrayList<Stuff>> getMaxValue = new ArrayList<ArrayList<Stuff>>();
        for(int i=0; i<2; i++) {
            getMaxValue.add(new ArrayList<Stuff>());
        }

        //base-case (첫번째 물건)
        getMaxValue.get(0).add(new Stuff(0, 0));    //getMaxValue[0][idx] 은 해당(idx) 물건을 포함할 때, K를 초과하지 않으면서 최대 가치인걸 저장한다
        getMaxValue.get(1).add(new Stuff(0, 0));    //getMaxValue[1][idx] 은 해당물건(idx)을 포함하지 않을 때, K를 초과하지 않으면서 최대 가치인걸 저장한다

        for(int i=0; i<stuffs.size(); i++) {
            //i번째 stuff를 포함할 때
            int tempMaxValue = 0;
            int tempWeight = 0;
            for(int j=i; j>=0; j--) {
                if(stuffs.get(i).w + getMaxValue.get(0).get(j).w <= K) {
                    if(getMaxValue.get(0).get(j).v > tempMaxValue) {    //최대 가치 알아내기
                        tempMaxValue = getMaxValue.get(0).get(j).v;
                        tempWeight = getMaxValue.get(0).get(j).w;
                    }
                }
            }
            tempMaxValue += stuffs.get(i).v;
            tempWeight += stuffs.get(i).w;

            getMaxValue.get(0).add(new Stuff(tempWeight, tempMaxValue));

            //i번째 stuff를 포함하지 않을 때
            if(getMaxValue.get(0).get(i).v > getMaxValue.get(1).get(i).v) {
                getMaxValue.get(1).add(new Stuff(getMaxValue.get(0).get(i).w, getMaxValue.get(0).get(i).v));
            } else {
                getMaxValue.get(1).add(new Stuff(getMaxValue.get(1).get(i).w, getMaxValue.get(1).get(i).v));
            }
        }

        int maxValue = 0;
        for(int i=0; i<getMaxValue.get(0).size(); i++) {
            if(getMaxValue.get(0).get(i).w <= K && getMaxValue.get(0).get(i).v > maxValue) {
                maxValue = getMaxValue.get(0).get(i).v;
            }
        }

        System.out.println(maxValue);
    }
}
