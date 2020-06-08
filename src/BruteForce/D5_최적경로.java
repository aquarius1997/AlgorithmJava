package BruteForce;

import java.util.*;

/**
 * 46min 0Fail
 */
public class D5_최적경로 {
    static int g_N = 0;    //집 개수
    static int[] g_visited;
    static House[] g_houses;
    static int[] g_company;
    static int [] g_myHome;
    static int g_minDist;

    /**
     * 집의 위치 정보를 저장한다
     */
    public static class House {
        int x;
        int y;

        public House(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void get_min_dist(int houseIdx, int cnt, int distSum, int preHouseIdx) {
        int xDist, yDist, dist;

        g_visited[houseIdx] = 1;
        if(cnt == 1) {  //첫번째 집일 경우 회사와의 거리를 구해서 누적한다
            xDist = g_houses[houseIdx].x - g_company[0];
            yDist = g_houses[houseIdx].y - g_company[1];
            if(xDist < 0) { xDist *= -1; }
            if(yDist < 0) { yDist *= -1; }
            dist = xDist + yDist;

            distSum += dist;

            //재귀호출
            for(int i=0; i<g_N; i++) {
                if(g_visited[i] == 0) {
                    get_min_dist(i, cnt+1, distSum, houseIdx);
                }
            }
        } else {    //이외의 경우는 이전 집과의 거리를 구해서 재귀호출
            xDist = g_houses[houseIdx].x - g_houses[preHouseIdx].x;
            yDist = g_houses[houseIdx].y - g_houses[preHouseIdx].y;
            if(xDist < 0) { xDist *= -1; }
            if(yDist < 0) { yDist *= -1; }
            dist = xDist + yDist;

            distSum += dist;
            //재귀호출
            for(int i=0; i<g_N; i++) {
                if(g_visited[i] == 0) {
                    get_min_dist(i, cnt+1, distSum, houseIdx);
                }
            }

            if(cnt == g_N) { //마지막 집일 경우 이전 집과의 거리, 내 집까지의 거리를 합해서 최소 거리인지 업데이트한다
                xDist = g_myHome[0] - g_houses[houseIdx].x;
                yDist = g_myHome[1] - g_houses[houseIdx].y;
                if(xDist < 0) { xDist *= -1; }
                if(yDist < 0) { yDist *= -1; }
                dist = xDist + yDist;

                distSum += dist;

                if(distSum < g_minDist) {
                    g_minDist = distSum;
                }
            }
        }

        g_visited[houseIdx] = 0;
    }

    public static void main(String[] args) {
        int T, t;
        int x, y;
        int i=0;

        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();

        g_company = new int[2];
        g_myHome = new int[2];
        g_houses = new House[11];
        g_visited = new int[11];

        for(t=1; t<=T; t++) {
            g_N = scanner.nextInt();

            //집과 회사 위치를 저장한다
            g_company[0] = scanner.nextInt();
            g_company[1] = scanner.nextInt();
            g_myHome[0] = scanner.nextInt();
            g_myHome[1] = scanner.nextInt();

            //집들의 정보를 입력받는다
            for(i=0; i<g_N; i++) {
                x = scanner.nextInt();
                y = scanner.nextInt();
                g_houses[i] = new House(x, y);
            }

            g_minDist = 987987987;
            //함수를 호출해 집을 모두 돈다
            for(i=0; i<g_N; i++) {
                get_min_dist(i, 1, 0, 0);
            }

            System.out.println("#" + t + " " + g_minDist);
        }
    }
}
