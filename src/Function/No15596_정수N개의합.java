package Function;

public class No15596_정수N개의합 {
    long sum(int[] a) {
        long tempSum = 0;
        for(int i=0; i<a.length; i++) {
            tempSum += a[i];
        }
        return tempSum;
    }
}
