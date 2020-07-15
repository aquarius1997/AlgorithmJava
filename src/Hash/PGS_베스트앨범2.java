package Hash;

import java.util.*;

/**
 * 소요시간 : 50min
 * Failcnt : 0
 * 체감난이도 : ****** (HashMap의 value정렬)
 */
public class PGS_베스트앨범2 {
    public class Music implements Comparable<Music>{
        int uniqNum;    //고유번호
        int plays;  //재생횟수

        public Music (int uniqNum, int plays) {
            this.uniqNum = uniqNum;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music music) { //음악 재생횟수가 많은것을 앞에 위치
            if(this.plays < music.plays) { return 1;}
            else if(this.plays > music.plays) { return -1;}
            else {
                if(this.uniqNum > music.uniqNum) { return 1; }
                else if(this.uniqNum == music.uniqNum) { return 0; }
                else { return  -1; }
            }
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> genresPlayCnt = new HashMap<String, Integer>();    //장르별로 플레이된 카운트 저장
        HashMap<String, ArrayList<Music>> musicList = new HashMap<String, ArrayList<Music>>();  //장르별 노래 저장

        for(int i=0; i<genres.length; i++) {
            if(genresPlayCnt.containsKey(genres[i])) {
                genresPlayCnt.put(genres[i], (genresPlayCnt.get(genres[i]) + plays[i]));   //재생횟수 더해주기
            } else {    //새로운 값 넣어주기
                genresPlayCnt.put(genres[i], new Integer(plays[i]));
                //hashMap생성
                musicList.put(genres[i], new ArrayList<Music>());
            }
            //장르에 따른 Music객체 생성해서 넣기
            ArrayList<Music> tempMusicList = musicList.get(genres[i]);
            tempMusicList.add(new Music(i, plays[i]));
            musicList.put(genres[i], tempMusicList);
        }

        //genresPlayCnt를 value로 정렬하기(내림차순)
        List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(genresPlayCnt.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
//                return obj2.getValue().compareTo(obj1.getValue());    //아래랑 동일
                if(obj1.getValue() < obj2.getValue()) return 1;
                else if(obj1.getValue() == obj2.getValue()) return 0;
                else return -1;
            }
        });

        ArrayList<Integer> tempAnswer = new ArrayList<Integer>();   //answer값 임시 저장
        String musicGenre = "";
        for(Map.Entry<String, Integer> entry : entries) {
            musicGenre = entry.getKey();    //장르 알아내서
            ArrayList<Music> sortMusicList = musicList.get(musicGenre); //장르에 해당하는 Music List가져오고
            Collections.sort(sortMusicList);    //정렬한다
            //최대 두 곡을 수록한다
            if(sortMusicList.size() < 2) {
                for(int i=0; i<sortMusicList.size(); i++) {
                    tempAnswer.add(sortMusicList.get(i).uniqNum);
                }
            } else {
                for(int i=0; i<2; i++) {
                    tempAnswer.add(sortMusicList.get(i).uniqNum);
                }
            }
        }

        answer = new int[tempAnswer.size()];
        for(int i=0; i<tempAnswer.size(); i++) {
            answer[i] = tempAnswer.get(i);
        }

        return answer;
    }
}
