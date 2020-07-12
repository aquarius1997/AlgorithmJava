package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class No11650_좌표정렬하기 {

    public static class Location implements Comparable<Location>{
        int x;  int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Location location) {   //오름차순
            if(location.x < this.x) return 1;
            else if(location.x > this.x) return -1;
            else {
                if(location.y < this.y) return 1;
                else if(location.y == this.y) return 0;
                else return -1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        ArrayList<Location> locationArrayList = new ArrayList<Location>();

        int x, y;
        for(int i=0; i<N; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            locationArrayList.add(new Location(x, y));
        }

        Collections.sort(locationArrayList);

        for(int i=0; i<N; i++) {
            System.out.println(locationArrayList.get(i).x + " " + locationArrayList.get(i).y);
        }

    }
}
