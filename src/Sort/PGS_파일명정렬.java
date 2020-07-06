package Sort;

import java.util.Arrays;


/**
 * 체감난이도 : *****    //Comparable, CompareTo 사용법 익히기에 진짜 좋은문제같음
 * FailCnt : 1
 * 시간 : 1h 5min
 */
public class PGS_파일명정렬 {

    class File implements Comparable<File> {
        String file;
        String head;
        String strNumber;
        int number;

        public File(String file) {
            this.file = file;

            char ch;
            head = "";
            int idx = 0;
            //대문자로 변환해서 head구하기
            for(;idx<file.length(); idx++) {
                ch = file.charAt(idx);
                if(ch >= '0' && ch <= '9') {    //숫자면 루프브레이크
                    break;
                } else if(ch >= 'a' && ch <='z') {
                    ch -= ('a' - 'A');
                }
                head += ch;
            }
            //숫자부분 str구하기
            strNumber = "";
            for(; idx<file.length(); idx++) {
                ch = file.charAt(idx);
                if(!(ch >= '0' && ch <= '9')) { //숫자아니 루프 브레이크
                    break;
                }
                strNumber += ch;
            }
            //strNumber 숫자로 변환해서 저장하기
            int tempNum = strNumber.charAt(0) - '0';
            for(int i=1; i<strNumber.length(); i++) {
                tempNum *= 10;
                tempNum += (strNumber.charAt(i) - '0');
            }

            number = tempNum;
        }

        @Override
        public int compareTo(File file){
            if(this.head.compareTo(file.head) == 0) {   //둘이 같음ㄴ
                if(this.number > file.number) {
                    return 1;
                } else if(this.number < file.number){
                    return -1;
                } else {    //같으면 인덱스 순이니깐
                    return 0;
                }
            } else if(this.head.compareTo(file.head) > 0) { //this.head가 더 크면
                return 1;
            } else {    //this.head가 더 작으면
                return -1;
            }
        }
    }

    public String[] solution(String[] files) {
        String[] answer = {};
        File[] sortedFiles = new File[files.length];

        for(int i=0; i<files.length; i++) {
            sortedFiles[i] = new File(files[i]);
        }

        Arrays.sort(sortedFiles);

        for(int i=0; i<files.length; i++) {
            System.out.println(sortedFiles[i].file + ", " + sortedFiles[i].number);
        }

        answer = new String[sortedFiles.length];
        for(int i=0; i<sortedFiles.length; i++) {
            answer[i] = sortedFiles[i].file;
        }

        return answer;
    }
}
