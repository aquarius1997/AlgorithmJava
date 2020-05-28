package SummerCoding;

public class Num1 {
    public int solution(int p) {
        int answer = 0;
        int[] countArr = new int[10];
        int first, second, third, fourth;

        for(int i=p+1; ; i++) {
            first = i / 1000;
            second = (i % 1000) / 100;
            third = (i % 100) / 10;
            fourth = (i % 10);

            countArr[first]++;

            //겹치는거 생기면
            if(countArr[second] == 1) {
                countArr[first] = 0;
                continue;
            }
            else { countArr[second]++; }

            if(countArr[third] == 1) {
                countArr[first] = countArr[second] = 0;
                continue;
            }
            else { countArr[third]++; }

            if(countArr[fourth] == 1) {
                countArr[first] = countArr[second] = countArr[third] = 0;
                continue;
            }
            else { countArr[fourth]++; }

            //여기까지오면 겹치는거 없음
            answer = i;
            break;
        }
        return answer;
    }
}
