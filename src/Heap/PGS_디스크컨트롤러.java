package Heap;

import java.util.PriorityQueue;

/**
 * 35min ****. 디스크 알고리즘의 non-preemptive SJF 를 생각하면 프로세스 자체는 어렵지 않음
 */
public class PGS_디스크컨트롤러 {

    /**
     * 디스크 요청과 관련한 정보들을 객체로 만들어 우선순위큐로 구현함에 필요
     */
    class DiskInput implements Comparable<DiskInput> {
        int arrivalTime;  //작업 요청 시점
        int burstTime;  //요청 처리 시간
        int jobIndex;   //작업의 인덱스

        public DiskInput(int arrivalTime, int burstTime, int jobIndex) {
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
            this.jobIndex = jobIndex;
        }

        //burstTime이 작은게 우선순위 높게
        @Override
        public int compareTo(DiskInput diskInput) {
            if(this.burstTime > diskInput.burstTime) return 1;
            else return -1;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;
        int[] endJobs = new int[jobs.length];   //힙에 요청이 들어간 작업은 1로 저장, 요청이 처리된 작업은 2로 저장
        PriorityQueue<DiskInput> priorityQueue = new PriorityQueue<DiskInput>();
        DiskInput minDisk;
        int endFlag = 0;
        int timeCnt = 0;
        int i;

        while(true) {
            endFlag = 0;    //모두 요청처리완료했으 0으로 계속 저장되어ㅣㅇㅆ

            //1. 현재 소요 시간을 기준으로 요청을 새로 넣을 수 있는 작업은 힙에 추가한다
            for (i = 0; i < jobs.length; i++) {
                if (endJobs[i] == 0) {   //요청이 들어가지 않은 작업들 중에서
                    if (jobs[i][0] <= timeCnt) { //요청을 넣을 수 있는 작업
                        priorityQueue.add(new DiskInput(jobs[i][0], jobs[i][1], i));
                        endJobs[i] = 1; //요청 들어감을 표시
                    }
                    endFlag = 1;
                } else if (endJobs[i] == 1) {
                    endFlag = 1;
                }
            }
            // end 1면

            //모든 요청을 처리 완료햇으면 나간다
            if (endFlag == 0) {
                break;
            }

            //2. 힙에서 가장 처리 시간이 작은걸 poll한다
            if (priorityQueue.size() > 0) {
                minDisk = priorityQueue.poll();

                //요청을 처리하고 시간을 업데이트 한다 + 요청 처리 완료를 표시한다
                timeCnt += minDisk.burstTime;
                //작업완료 시점 - 대기시간 을 누적한다
                answer += (timeCnt - minDisk.arrivalTime);
                endJobs[minDisk.jobIndex] = 2;
            } else { //아직 힙에 들어간게 없으면 시간 하나 증가시킨다
                timeCnt++;
            }

        }

        //평균을 구한다
        answer = answer / jobs.length;


        return answer;
    }
}
