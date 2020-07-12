package Greedy;

/**
 * 22min
 * FailCnt : 0
 * 체감난이도 : **
 */
public class PGS_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        final int N = 33;
        int answer = 0;
        int[] clothesCnt = new int[N];
        int[] borrowCnt = new int[N];   //인접한 학생중 옷을 두벌가진 애들이 몇명인지 저장

        for(int i=1; i<=n; i++) { //모두 1벌씩 있는걸로 초기화
            clothesCnt[i]  = 1;
        }
        for(int i=0; i<lost.length; i++) { //없어진 애들 처리
            clothesCnt[lost[i]]--;
        }
        for(int i=0; i<reserve.length; i++) { //여분 있는 애들 처리
            clothesCnt[reserve[i]]++;
        }

        //borrow배열 초기화
        for(int i=1; i<=n; i++) {
            if(clothesCnt[i] == 0) {
                if(clothesCnt[i-1] == 2) {
                    borrowCnt[i]++;
                }
                if(clothesCnt[i+1] == 2) {
                    borrowCnt[i]++;
                }
            }
        }

        //빌릴수 잇는 친구가 1명인 애들부터 처리
        for(int i=1; i<=n; i++) {
            if(clothesCnt[i] == 0 && borrowCnt[i] == 1) {
                if(clothesCnt[i-1] == 2) {  //빌릴 수 있는 친구가 왼쪽이면
                    clothesCnt[i-1]--;  clothesCnt[i] = 1;
                } else if(clothesCnt[i+1] == 2){    //빌릴 수 있는 친구가 오른쪽에 잇으면
                    clothesCnt[i+1]--;  clothesCnt[i] = 1;
                }
            }
        }

        //그다음 빌릴 수 있는 친구가 2명이었던 애들 처리
        for(int i=1; i<=n; i++) {
            if(clothesCnt[i] == 0 && borrowCnt[i] == 2) {
                if(clothesCnt[i-1] == 2) {
                    clothesCnt[i-1]--;  clothesCnt[i] = 1;
                } else if(clothesCnt[i+1] == 2){
                    clothesCnt[i+1]--;  clothesCnt[i] = 1;
                }
            }
        }

        //옷 입을 수 있는 애들 구하기
        for(int i=1; i<=n; i++) {
            if(clothesCnt[i] > 0) {
                answer++;
            }
        }

        return answer;
    }
}
