package HyundaiCardTest;

public class Num3 {
    public int solution(String[] ip_addrs, String[] langs, int[] scores) {
        int answer = 0;
        int[] notInclude = new int[ip_addrs.length];    //부정 : 1
        int[] visited = new int[ip_addrs.length];
        int cLan, jLan, jsLan, pLan;
        int same = 0;

        for(int i=0; i<ip_addrs.length; i++) {
            same = 1;
            cLan = jLan = jsLan = pLan =0;

            if(visited[i] == 0) {
                //같은 아이피 개수 찾
                for(int j=i+1; j<ip_addrs.length; j++) {
                    if(ip_addrs[i].equals(ip_addrs[j])) {
                        same += 1;
                        visited[j] = 1;
                    }
                }

                //case 1
                if(same >= 4) {
                    notInclude[i] = 1;
                    //같은 아이피 개수 찾
                    for(int j=i+1; j<ip_addrs.length; j++) {
                        if(ip_addrs[i].equals(ip_addrs[j])) {
                            notInclude[j] = 1;
                        }
                    }
                }
                //case12
                else if(same == 3) {
                    if (langs[i].charAt(0) == 'C') {
                        cLan = 1;
                    } else if (langs[i].equals("Java")) {
                        jLan = 1;
                    } else if (langs[i].equals("JavaScript")) {
                        jsLan = 1;
                    } else {
                        pLan = 1;
                    }

                    for (int j = i + 1; j < ip_addrs.length; j++) {
                        if (ip_addrs[i].equals(ip_addrs[j])) {
                            //같은 언어 개수 알아내기
                            if (langs[j].charAt(0) == 'C') {
                                cLan++;
                            } else if (langs[j].equals("Java")) {
                                jLan++;
                            } else if (langs[j].equals("JavaScript")) {
                                jsLan++;
                            } else {
                                pLan++;
                            }
                        }
                    }

                    //부정 처리
                    if(cLan == 3 || jLan == 3 || jsLan == 3 || pLan == 3) {
                        notInclude[i] = 1;
                        //같은 아이피 개수 찾
                        for(int j=i+1; j<ip_addrs.length; j++) {
                            if(ip_addrs[i].equals(ip_addrs[j])) {
                                notInclude[j] = 1;
                            }
                        }
                    }
                }
                //case3
                else if(same == 2) {
                    if (langs[i].charAt(0) == 'C') {
                        cLan = 1;
                    } else if (langs[i].equals("Java")) {
                        jLan = 1;
                    } else if (langs[i].equals("JavaScript")) {
                        jsLan = 1;
                    } else {
                        pLan = 1;
                    }

                    for (int j = i + 1; j < ip_addrs.length; j++) {
                        if (ip_addrs[i].equals(ip_addrs[j])) {
                            //같은 언어 개수 알아내기
                            if (langs[j].charAt(0) == 'C') {
                                if(cLan == 1) {
                                    if(scores[i] == scores[j]) {
                                        notInclude[i] = notInclude[j] = 1;
                                    }
                                }
                            } else if (langs[j].equals("Java")) {
                                if(jLan == 1) {
                                    if(scores[i] == scores[j]) {
                                        notInclude[i] = notInclude[j] = 1;
                                    }
                                }
                            } else if (langs[j].equals("JavaScript")) {
                                if(jsLan == 1) {
                                    if(scores[i] == scores[j]) {
                                        notInclude[i] = notInclude[j] = 1;
                                    }
                                }
                            } else {
                                if(pLan == 1) {
                                    if(scores[i] == scores[j]) {
                                        notInclude[i] = notInclude[j] = 1;
                                    }
                                }
                            }
                        }
                    }
                }
                //end case3

            }

        }

        for(int i=0; i<notInclude.length; i++) {
            if(notInclude[i] == 0) {
                answer++;
            }
        }
        return answer;
    }
}
