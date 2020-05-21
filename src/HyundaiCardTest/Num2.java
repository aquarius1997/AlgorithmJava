package HyundaiCardTest;

public class Num2 {
    public String solution(String[] registered_list, String new_id) {
        String answer = "";
        int charLen = 0;
        int numLen = 0;
        int flag = 1;
        String nextNewId = new_id;

        while(true) {
            flag = 0;

            for(int i=0; i<registered_list.length; i++) {
                if (registered_list.equals(nextNewId)) {
                    flag = 1;
                }
            }

            if(flag == 0) {
                break;
            }

            numLen = charLen =0;
            //2
            for(int i=0; i<nextNewId.length(); i++) {
                if(nextNewId.charAt(i) >= '0' && nextNewId.charAt(i) <= '9') {
                    numLen++;
                } else {
                    charLen++;
                }
            }


            String subStr = nextNewId.substring(0, charLen);
            int subNum = 0;

            if(numLen == 0) {
                subNum = 1;
                nextNewId = subStr + subNum;
            } else {
                subNum = nextNewId.charAt(charLen) - '0';
                //10 진수로 변환
                for(int j=charLen+1; j<nextNewId.length(); j++) {
                    subNum *= 10;
                    subNum += nextNewId.charAt(j) - '0';
                }

                nextNewId = subStr + subNum;
            }

        }

        answer = nextNewId;

        return answer;
    }
}
