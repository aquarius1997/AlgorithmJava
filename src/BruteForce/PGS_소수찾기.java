package BruteForce;

import java.util.ArrayList;

public class PGS_소수찾기 {
    ArrayList<Integer> primeN = new ArrayList<Integer>();
    int[] visited = new int[9];
    int g_primeCnt = 0;

    /**
     * 완전탐색으로 모든 경우의 숫자를 만들고 소수인지 확인
     * @param numbers 입력 문자열
     * @param idx 문자를 숫자로 만들 인덱스
     * @param num 현재까지 만든 숫자
     */
    public void bf(String numbers, int idx, int num) {
        int n = 0;

        visited[idx] = 1;
        //숫자 만들고
        n = (num * 10) + (numbers.charAt(idx) - '0');
        //소수인지 확인
        for(int i=0; i<primeN.size(); i++) {
            if(primeN.get(i) == n) {
                g_primeCnt++;
                //같은 수 또 확인안하려고 빼기
                primeN.remove(i);
                break;
            }
            //확인할 범위 줄이기
            if(n < primeN.get(i)) { break; }
        }

        //다른 숫자 만들기
        for(int i=0; i<numbers.length(); i++) {
            if(visited[i] == 0) {
                bf(numbers, i, n);
            }
        }


        visited[idx] = 0;
    }

    public int solution(String numbers) {
        int answer = 0;
        int divN = 0;
        int flag = 0;

        //소수 구해놓
        primeN.add(2);
        for(int i=3; i<9999999; i++) {
            divN = (int)Math.sqrt(i);

            flag = 0;
            for(int j=0; j<primeN.size(); j++) {
                if(primeN.get(j) > divN) { break; }
                if(i % primeN.get(j) == 0) {
                    flag = 1;   break;
                }
            }
            //2~루트(i) 범위 이내의 모든 소수로부터 i가 나누어 떨어지지 않으면 소수
            if(flag == 0) {
                primeN.add(i);
            }
        }

        for(int i=0; i<numbers.length(); i++) {
            bf(numbers, i, 0);
        }

        answer = g_primeCnt;

        return answer;
    }
}
