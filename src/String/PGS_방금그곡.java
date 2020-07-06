package String;

import java.util.ArrayList;

/**
 * FailCnt = 3;
 * 체감난이도 : ****
 * #이 들어간 조음은 소문자로 변경해서 저장하는 방식으로 바꿨더니 훨씬 깔끔하고 쉬운 코드가 됨
 * Ex) CDCF#C#A -> CDCfcA
 */
public class PGS_방금그곡 {
    int[] g_runningTime;  //노래들의 재생 시간[m]을 저장
    ArrayList<Integer> musicIdx = new ArrayList<Integer>(); //조건을 만족하는 음악의 인덱스를 저장한다

    /**
     * 각 노래들의 재생 시간을 구해서 g_runningTime 배열에 저장한다
     * @param musicinfos
     */
    public void get_running_time(String[] musicinfos) {
        int h = 0;  int m = 0;

        for(int i=0; i<musicinfos.length; i++) {
            int startTime, endTime;

            startTime = endTime = 0;
            h = m = 0;

            //시작 시간 구하기
            h = musicinfos[i].charAt(0) - '0';
            h *= 10;
            h += musicinfos[i].charAt(1) - '0';

            m = musicinfos[i].charAt(3) - '0';
            m *= 10;
            m += musicinfos[i].charAt(4) - '0';

            startTime = (h * 60) + m;

            //종료 시간 구하기
            h = m = 0;
            h = musicinfos[i].charAt(6) - '0';
            h *= 10;
            h += musicinfos[i].charAt(7) - '0';

            m = musicinfos[i].charAt(9) - '0';
            m *= 10;
            m += musicinfos[i].charAt(10) - '0';

            endTime = (h * 60) + m;

            //재생시간 저장
            g_runningTime[i] = endTime - startTime;
        }
    }

    public void find_music(String m, String[] musicinfos) {

        //m의 #을 변환한 음을 알아낸다
        char tempCh;
        String mStr = "";
        for(int i=0; i<m.length(); i++) {
            if(i+1 < m.length()) {
                if(m.charAt(i+1) == '#') {
                    tempCh = m.charAt(i);
                    tempCh += ('a' - 'A');
                    mStr += tempCh;
                    i += 1;
                } else {
                    mStr += m.charAt(i);
                }
            } else {
                mStr += m.charAt(i);
            }
        }


        for(int i=0; i<musicinfos.length; i++) {

            int musicTitleEndIdx = 0;
            musicTitleEndIdx = musicinfos[i].indexOf(',', 12);  //노래제목 뒤에 바로 나오는 , 의 위치를 찾음

            //#을 변환한 음을 알아내서 저장한다
            String tempStr = "";
            for(int j=musicTitleEndIdx+1; j<musicinfos[i].length(); j++) {
                if(j+1 < musicinfos[i].length()) {
                    if(musicinfos[i].charAt(j+1) == '#') {
                        //소문자로 변경해서 저장하기
                        tempCh = musicinfos[i].charAt(j);
                        tempCh += ('a' - 'A');
                        tempStr += tempCh;
                        j += 1;
                    } else {
                        tempStr += musicinfos[i].charAt(j);
                    }
                } else {
                    tempStr += musicinfos[i].charAt(j);
                }
            }

            //노래의 멜로디 길이를 알아낸다
            int musicLen = tempStr.length();

            //노래가 얼마나 틀어진건지 확인한다
            String musicStr = "";   //노래가 틀어진 부분을 저장
            int tMusicRunningTime = g_runningTime[i];
            int cnt = 0;
            while(true) {
                if(tMusicRunningTime == 0) {
                    break;
                } else if(tMusicRunningTime < musicLen) {
                    cnt = 0;
                    for(int j=0; j<tempStr.length(); j++) {
                        musicStr += tempStr.charAt(j);
                        cnt++;
                        if(cnt == tMusicRunningTime) {
                            tMusicRunningTime = 0;
                            break;
                        }
                    }
                } else {
                    for(int j=0; j<tempStr.length(); j++) {
                        musicStr += tempStr.charAt(j);
                    }
                    tMusicRunningTime -= musicLen;
                }
            }

            //찾으려던 노래가 맞는지 확인한다
            if(musicStr.contains(mStr)) {
                musicIdx.add(i);
            }
        }
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        g_runningTime = new int[musicinfos.length];

        get_running_time(musicinfos);

        find_music(m, musicinfos);

        if(musicIdx.size() == 0) {
            answer = "(None)";
        } else if(musicIdx.size() == 1) {
            int idx = musicIdx.get(0);
            //노래 제목 알아내기
            int musicTitleEndIdx = 0;
            musicTitleEndIdx = musicinfos[idx].indexOf(',', 12);  //노래제목 뒤에 바로 나오는 , 의 위치를 찾음
            String musicTitle = musicinfos[idx].substring(12, musicTitleEndIdx);

            answer = musicTitle;
        } else {    //조건 일치하는 음악의 개수가 2개 이상이면 재생시간이 가장 긴걸 찾는다
            int maxRunningTime = g_runningTime[(musicIdx.get(0))];
            int firstMaxIdx = musicIdx.get(0);

            for(int i=1; i<musicIdx.size(); i++) {
                if(g_runningTime[(musicIdx.get(i))] > maxRunningTime) {
                    firstMaxIdx = musicIdx.get(i);
                    maxRunningTime = g_runningTime[(musicIdx.get(i))];
                }
            }

            int idx = firstMaxIdx;
            //노래 제목 알아내기
            int musicTitleEndIdx = 0;
            musicTitleEndIdx = musicinfos[idx].indexOf(',', 12);  //노래제목 뒤에 바로 나오는 , 의 위치를 찾음
            String musicTitle = musicinfos[idx].substring(12, musicTitleEndIdx);

            answer = musicTitle;
        }

        return answer;
    }
}
