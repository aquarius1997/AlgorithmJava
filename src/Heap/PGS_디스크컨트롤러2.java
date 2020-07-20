package Heap;
import java.util.*;

/**
 * 소요시간 : 2h 30min
 * 두번째 풀어보는건데 오히려 첫번째 풀었던것보다 어렵게 생각해서 오래걸리고 헤멤
 * 체감난이도 : ****
 * FailCnt : 3
 * 주의점 : 문제 조건이 좀 모호한게 있음. "하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다." 라고 적혀있지만, 같은 시간에 대해 [0, 4], [0, 1]과 같이 들어왔다면 [0, 1]부터 처리해야함
 */
public class PGS_디스크컨트롤러2 {
    public class Job implements Comparable<Job> {
        int orderS; //요청시간
        int leadTime;   //작업소요시간

        public Job(int orderS, int leadTime) {
            this.orderS = orderS;
            this.leadTime = leadTime;
        }

        @Override
        public int compareTo(Job job) { //작업 소요시간이 작은게 우선순위가 높도록 설정
            if(this.leadTime > job.leadTime) return 1;
            else if(this.leadTime == job.leadTime) return 0;
            else return -1;
        }
    }

    public int solution(int[][] jobs) {
        int answer = 0;

        List<Job> jobList = new ArrayList<Job>();
        for(int i=0; i<jobs.length; i++) {
            jobList.add(new Job(jobs[i][0], jobs[i][1]));
        }
        //요청이 들어온 순서대로 정렬하기
        Collections.sort(jobList, new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                if(job1.orderS > job2.orderS) return 1;
                else if(job1.orderS == job2.orderS) {
                    if(job1.leadTime > job2.leadTime) return 1;
                    else if(job1.leadTime == job2.leadTime) return 0;
                    else return -1;
                }
                else return -1;
            }
        });

        //작업 소요시간이 작은게 우선순위가 높은 힙
        PriorityQueue<Job> jobPriorityQueue = new PriorityQueue<>();
        int jobIdx = 0;
        int sec = 0;
        int flag = 0;
        int completeJobCnt = 0;

        while(true) {   //Job들을 완료시킨다
            //현재 처리하는 요청이 끝나기 전에 새로운 요청이 들어오면 큐에 삽입
            for(; jobIdx<jobList.size();) {
                if(jobList.get(jobIdx).orderS <= flag) {
                    jobPriorityQueue.add(new Job(jobList.get(jobIdx).orderS, jobList.get(jobIdx).leadTime));
                    jobIdx++;
                } else { break; }
            }

            if(jobPriorityQueue.isEmpty()) { //새로운 요청을 받아야 하는 시점이면
                jobPriorityQueue.add(new Job(jobList.get(jobIdx).orderS, jobList.get(jobIdx).leadTime));
                jobIdx++;
                sec = jobPriorityQueue.peek().orderS;
            }

            Job newJob = jobPriorityQueue.poll();
            flag = sec + newJob.leadTime;   //flag를 현재 처리하게 될 요청이 끝나는 시간으로 설정
            answer += (sec - newJob.orderS) + newJob.leadTime;  //요청부터 종료까지 걸린시간 누적

            //현재 요청 끝내기
            sec = flag;
            completeJobCnt++;

            if(completeJobCnt == jobs.length) break;    //모든 작업 요청을 처리한 경우 루프 브레이크
        }

        answer /= jobs.length;


        return answer;
    }
}
