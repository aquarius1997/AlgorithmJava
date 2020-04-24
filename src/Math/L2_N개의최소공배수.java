package Math;

class L2_N개의최소공배수 {

    /**
     * a 와 b의 최대공약수를 유클리드 호제법을 이용해 구한다
     * @param a
     * @param b
     * @return 최대 공약수
     */
    public int get_gcd(int a, int b) {
        int r;

        if(b > a) {
            int temp = b;
            temp = a;
            a = temp;
        }

        while(true) {   //큰 수를 작은수로 나눴을때, 나머지를 구한다. 나머지가 0이될때까지 반복하며 0일때, 작은 수가 최대공약수다 (유클리드 호제법)
            r = a % b;
            if(r == 0) {
                break;
            }
            a = b;
            b = r;
        }
        return b;
    }

    public int solution(int[] arr) {
        int answer = 0;
        int lastLcm, lastGcd;
        if(arr.length == 1) {
            lastLcm = arr[0];
        } else {
            lastGcd = get_gcd(arr[0], arr[1]);
            lastLcm = (arr[0] * arr[1] / lastGcd);
        }

        for(int i=1; i<arr.length; i++) {
            lastGcd = get_gcd(arr[i], lastLcm);
            lastLcm = (arr[i] * lastLcm / lastGcd);
        }

        answer = lastLcm;

        return answer;
    }
}