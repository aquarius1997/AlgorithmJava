package BruteForce;

import java.util.*;

public class D5_최적경로 {
    static int houses[][];
    static int company[];
    static int home[];
    static int visited[];
    static int N;
    static int minDist;

    /**
     * 모든 집들을 모든 경우의 수에 대해 방문한다
     * @param preHouse 이전에 방문한 집의 인덱스
     * @param idx 현재 방문할 집의 인덱스
     * @param cnt 여태까지 방문한 집의 수
     * @param dist 여태까지 이동한 거리
     */
    public static void visiting(int preHouse, int idx, int cnt, int dist) {
        int rowDist, colDist;
        int distance;

        visited[idx] = 1;

        if(preHouse == 0) { //첫번째 집이면 회사로부터 거리를 구한다
            rowDist = company[0] - houses[idx][0];
            colDist = company[1] - houses[idx][1];
        } else {    //첫번째 집이 아니면 이전 집과의 거리를 구한다
            rowDist = houses[preHouse][0] - houses[idx][0];
            colDist = houses[preHouse][1] - houses[idx][1];
        }
        if(rowDist < 0) {
            rowDist *= (-1);
        }
        if(colDist < 0) {
            colDist *= (-1);
        }
        distance = rowDist + colDist;

        if(cnt >= N) {  //집으로 가고 종료
            //현재 집으로부터 집까지의 거리를 구해 더한다
            rowDist = home[0] - houses[idx][0];
            colDist = home[1] - houses[idx][1];
            if(rowDist < 0) {
                rowDist *= (-1);
            }
            if(colDist < 0) {
                colDist *= (-1);
            }
            distance += (rowDist + colDist);
            //update minDist
            if(distance + dist < minDist) {
                minDist = distance + dist;
            }
        } else {    //call recursive function
            for(int i=1; i<=N; i++) {
                if(visited[i] == 0) {
                    visiting(idx, i, cnt+1, dist+distance);
                }
            }
        }

        visited[idx] = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T, t;
        houses = new int[11][2];
        company = new int[2];
        home = new int[2];
        visited = new int[11];

        T = scanner.nextInt();
        for(t=1; t<=T; t++) {
            N = scanner.nextInt();
            company[0] = scanner.nextInt(); company[1] = scanner.nextInt();
            home[0] = scanner.nextInt();    home[1] = scanner.nextInt();

            for(int i=1; i<=N; i++) {
                houses[i][0] = scanner.nextInt();   houses[i][1] = scanner.nextInt();
            }

            minDist = 987987987;

            for(int i=1; i<=N; i++) {
                visiting(0, i, 1, 0);
            }

            System.out.println("#" + t + " " + minDist);
        }
    }
}
