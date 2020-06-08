package Hash;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 35min 0Fail ***
 */
public class PGS_오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> userInfo = new HashMap<String, String>();
        ArrayList<String> uidArray = new ArrayList<String>();
        ArrayList<Integer> outOrIn = new ArrayList<Integer>();  //들어온거면 1, 나간거면 -1
        String mainUser = "";
        int j = 0;

        String tempUid, nn;
        for(int i=0; i<record.length; i++) {
            tempUid = nn = "";

            if(record[i].charAt(0) == 'E') {    //Enter
                //uid, nn 알아내기
                for(j=6; j<record[i].length(); j++) {
                    if(record[i].charAt(j) == ' ') { break; }
                    tempUid += record[i].charAt(j);
                }
                nn = record[i].substring(j+1, record[i].length());
                userInfo.put(tempUid, nn);

                //닉네임 바꿔서 들어온거면
                if(userInfo.containsKey(tempUid)) {
                    //닉네임 변경해주기
                    userInfo.replace(tempUid, nn);
                } else {    //새로운 유저면
                    userInfo.put(tempUid, nn);
                }

                uidArray.add(tempUid);
                outOrIn.add(new Integer(1));
            } else if(record[i].charAt(0) == 'L') { //Leave
                //uid알아내기
                for(j=6; j<record[i].length(); j++) {
                    if(record[i].charAt(j) == ' ') { break; }
                    tempUid += record[i].charAt(j);
                }

                uidArray.add(tempUid);
                outOrIn.add(new Integer(-1));
            } else {    //Change
                //uid, nn 알아내기
                for(j=7; j<record[i].length(); j++) {
                    if(record[i].charAt(j) == ' ') { break; }
                    tempUid += record[i].charAt(j);
                }
                nn = record[i].substring(j+1, record[i].length());

                userInfo.replace(tempUid, nn);
            }
        }

        answer = new String[uidArray.size()];
        String tempMessage = "";
        for(int i=0; i<uidArray.size(); i++) {
            tempMessage = "";
            if(outOrIn.get(i) == 1) {   //Enter
                tempUid = uidArray.get(i);
                nn = userInfo.get(tempUid);
                tempMessage += nn;
                tempMessage += "님이 들어왔습니다.";
                answer[i] = tempMessage;
            } else { //Leave
                tempUid = uidArray.get(i);
                nn = userInfo.get(tempUid);
                tempMessage += nn;
                tempMessage += "님이 나갔습니다.";
                answer[i] = tempMessage;
            }
        }

        return answer;
    }
}
