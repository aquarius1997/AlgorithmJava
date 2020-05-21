import java.util.LinkedList;


public class Num1 {
    class PurchaseObj {
        int price;
        int dayLeft;

        public PurchaseObj(int price, int dayLeft) {
            this.price = price;
            this.dayLeft = dayLeft;
        }
    }

    public int[] solution(String[] purchase) {
        int[] answer = {};
        int purchaseIdx = 0;
        int month = 1;  int day = 1;
        int purchaseMonth, purchaseDay, purchasePirce;
        int purchaseSum = 0;
        int bCnt, sCnt, gCnt, fCnt, diaCnt;
        LinkedList<PurchaseObj> linkedList = new LinkedList<PurchaseObj>();

        bCnt = sCnt = gCnt = fCnt = diaCnt = 0;

        for(int dayCnt = 1; dayCnt <= 365; dayCnt++) {
            //1. 물건 구입날 알아내서 해당 날짜면 넣
            if(purchaseIdx < purchase.length) {
                if(purchase[purchaseIdx].charAt(5) == '0') {    //구입 월 구하기
                    purchaseMonth = purchase[purchaseIdx].charAt(6) - '0';
                } else {    //10-12
                    purchaseMonth = 10;
                    purchaseMonth += purchase[purchaseIdx].charAt(6) - '0';
                }
                //구입 일 구하기
                if(purchase[purchaseIdx].charAt(8) == '0') {
                    purchaseDay = purchase[purchaseIdx].charAt(9) - '0';
                } else {
                    purchaseDay = purchase[purchaseIdx].charAt(8) - '0';
                    purchaseDay *= 10;

                    purchaseDay += purchase[purchaseIdx].charAt(9) - '0';
                }

                //큐에 push , 물건 인덱스 증가
                if(purchaseMonth == month && purchaseDay == day) {

                    //물건 가격 알아내기
                    purchasePirce = purchase[purchaseIdx].charAt(11) - '0';
                    for(int i=12; i<purchase[purchaseIdx].length() - 3; i++) {
                        purchasePirce *= 10;
                        purchasePirce += (purchase[purchaseIdx].charAt(i) - '0');
                    }

                    purchasePirce *= 1000;


                    linkedList.add(new PurchaseObj(purchasePirce, 30));
                    purchaseIdx++;
                }
            }
            // 1

            int tempPrice, tempDay;
            purchaseSum = 0;

            for(int i=0; i<linkedList.size(); i++) {
                if(linkedList.get(i).dayLeft > 0) {
                    purchaseSum += linkedList.get(i).price;
                }
            }
            for(int i=0; i<linkedList.size(); i++) {
                tempDay = linkedList.get(i).dayLeft - 1;
                tempPrice = linkedList.get(i).price;
                linkedList.remove(i);

                if(tempDay > 0) {
                    linkedList.add(new PurchaseObj(tempPrice, tempDay));
                }
            }


            System.out.println(month + " " + day + " " + purchaseSum);
            //등급 카운
            if(purchaseSum < 10000) { bCnt++; }
            else if(purchaseSum < 20000) { sCnt++; }
            else if(purchaseSum < 50000) { gCnt++; }
            else if(purchaseSum < 100000) { fCnt++; }
            else { diaCnt++; }

            //날짜 변경하기
            if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month ==10 || month == 12) {
                if(day == 31) {
                    day = 1;
                    month++;
                } else {
                    day++;
                }
            } else {
                if(month == 2) {
                    if(day == 28) { day = 1;
                        month++;
                    }
                    else {
                        day++;
                    }
                } else {
                    if(day == 30) {
                        day = 1;
                        month++;

                    } else {
                        day++;
                    }
                }
            }

        }


        answer = new int[5];

        for(int i=0; i<5; i++) {
        System.out.println(answer[i]);
        }
        answer[0] = bCnt;
        answer[1] = sCnt;
        answer[2] = gCnt;
        answer[3] = fCnt;
        answer[4] = diaCnt;

        return answer;
    }
}