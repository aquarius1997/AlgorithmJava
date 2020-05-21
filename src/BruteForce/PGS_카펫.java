package BruteForce;

public class PGS_카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};  answer = new int[2];
        int h = 1;  int w = 0;  int cal = 0;

        while(true) {
            cal = (((brown + 4) / 2) * h) - (h*h) - yellow - brown;
            if(cal == 0) {  //가로길이가 세로길이보다 작으면 둘의 길이 바꿔주기
                w = ((brown + 4) / 2) - h;
                if(w < h) {
                    int temp = w;
                    w = h;
                    h = temp;
                }
                break;
            }
            h++;
        }

        answer[0] = w;
        answer[1] = h;
        return answer;
    }
}
