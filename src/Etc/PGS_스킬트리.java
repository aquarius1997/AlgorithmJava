package Etc;

import java.util.Arrays;

public class PGS_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int[] skillIdx = new int[30]; //skill_trees[i] 문자열에 skill 문자가 있으면 해당 인덱스 저장. 없으면 -1.
        int answer = 0;
        int preIdx = 0;
        int answerFlag = 0;
        int i, j, k;

        //1. 유저가 생성한 모든 스킬 트리에 대해 검사한다
        for(i=0; i<skill_trees.length; i++) {
            //1-1. 모두 없는거로 초기화
            Arrays.fill(skillIdx, -1);
            //1-2. skill 문자들이 skill_tree[i]의 어느 위치에 있는지 저장
            for(j=0; j<skill.length(); j++) {
                for(k=0; k<skill_trees[i].length(); k++) {
                    if (skill.charAt(j) == skill_trees[i].charAt(k)) {
                        skillIdx[j] = k;    //인덱스 저장
                        break;
                    }
                }
            }
            //1-3. 스킬트리에 잘 따랐는지 확인한다
            preIdx = -1;
            answerFlag = 0; //주어진 스킬트리에 맞지 않을 경우 1
            for(j=0; j<skill.length(); j++) {
                if(skillIdx[j] == -1) { //해당 글자가 유저 스킬트리에 없었을 경우
                    for (k = j + 1; k < skill.length(); k++) {
                        if (skillIdx[k] != -1) {
                            answerFlag = 1;
                            break;
                        }
                    }
                } else if(answerFlag == 0) {
                    //해당 문자가 유저 스킬트리에 있는경우
                    if (skillIdx[j] < preIdx) {  //주어진 스킬트리에 맞지 않을 경우
                        answerFlag = 1;
                        break;
                    } else {
                        preIdx = skillIdx[j];
                    }
                }
            }   //end 1-3

            //1-4. 스킬트리에 잘 따랐을 경우 정답 개수 카운팅
            if(answerFlag == 0) {
                answer++;
            }
        }

        return answer;
    }
}
