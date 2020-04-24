package String;

public class PGS_문자열압축 {
    public int solution(String s) {
        String str1, str2;
        int answer = 0;
        int strLen = s.length();
        int compressedLen = 0;
        int cnt = 0;

        //압축 안된 상태로 일단 저장
        answer = strLen;

        for(int k=1; k<=strLen/2; k++) {    //k길이씩 문자열 반복을 확인한다
            compressedLen = 0;
            for(int i=0; i<strLen;) {
                cnt = 1;
                //길이 k만큼 잘라낼 수 있으면
                if(i+k <= strLen) {
                    str1 = s.substring(i, i+k);
                    //몇개나 반복되는지 알아내기
                    for(int j=i+k; j<strLen;) {
                        if(j+k <= strLen) { //길이 k만큼 확인할 수 있는 경우만
                            str2 = s.substring(j, j+k);
                            if (str1.equals(str2)) {
                                cnt++;
                                j = j+k;
                            } else { break; }
                        } else { break;}
                    }
                    //반복된 개수로 문자열 길이 업데이트
                    if(cnt > 1) {
                        if(cnt > 10) { compressedLen += 2; }
                        else if(cnt > 100) { compressedLen += 3;}
                        else if(cnt > 1000) { compressedLen += 4;}
                        else { compressedLen += 1;}
                    }
                    compressedLen += k;
                    i += (cnt * k);
                } else {    //길이 k만큼 못자르면 남은거 그대로 붙이기
                    compressedLen += (strLen - i);
                    break;
                }
            }   //end for(i)
            //최소 길이로 업데이
            if(compressedLen < answer) {
                answer = compressedLen;
            }
        }   //end for(k)

        return answer;
    }
}
