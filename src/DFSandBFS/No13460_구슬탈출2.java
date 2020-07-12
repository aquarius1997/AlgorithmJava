package DFSandBFS;
import java.util.*;

public class No13460_구슬탈출2 {
    static final int INFI = -1; //불가능한 경우
    static int N, M;
    static String[] board;
    static RedMarble redMarble;    static BlueMarble blueMarble;
    static int tempAnswer = INFI;

    /*
    빨간 구슬의 위치를 저장한다
     */
    public static class RedMarble {
        int row;
        int col;

        public RedMarble(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /*
    파란 구슬의 위치를 저장한다
     */
    public static class BlueMarble {
        int row;
        int col;

        public BlueMarble(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void moveUp(int roundCnt) {
        if(roundCnt == 10) { return; }

        int redDist = 0;    int blueDist = 0;
        int redFlag = 0;    int blueFlag = 0;   //구멍에 빠지면 1
        //빨간 구슬과 파란 구슬의 마지막 위치 구하기
        for(int i=redMarble.row-1; i>=0; i--) {
            if(board[i].charAt(redMarble.col) == 'O') {
                redFlag = 1;    break;
            } else if(board[i].charAt(redMarble.col) == '#') {
                break;
            } else {
                redDist++; continue;
            }
        }
        for(int i=blueMarble.row-1; i>=0; i--) {
            if(board[i].charAt(blueMarble.col) == 'O') {
                blueFlag = 1;   break;
            } else if(board[i].charAt(blueMarble.col) == '#') {
                break;
            } else {
                blueDist++; continue;
            }
        }

        //구멍에 빠진 구슬이있으면 확인하기
        if(blueFlag == 1) { return; }
        if(redFlag == 1) {
            if(tempAnswer == INFI) { tempAnswer = roundCnt; }
            else {
                if(tempAnswer > roundCnt) { tempAnswer = roundCnt; }
            }
            return;
        }

        //둘의 최종 위치 저장하기
        if((redMarble.row - redDist != blueMarble.row - blueDist) || (redMarble.col != blueMarble.col)) {   //둘의 최종 위치가 다르면 그대로 저장
            redMarble.row -= redDist;
            blueMarble.row -= blueDist;
        } else {
            if(redDist < blueDist) {
                redMarble.row -= redDist;
                blueMarble.row = redMarble.row + 1;
            } else {
                blueMarble.row -= blueDist;
                redMarble.row = blueMarble.row + 1;
            }
        }

        //원래 위치 저장
        RedMarble tempRedMarble = new RedMarble(redMarble.row, redMarble.col);
        BlueMarble tempBlueMarble = new BlueMarble(blueMarble.row, blueMarble.col);

        moveDown(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveLeft(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveRight(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;
    }

    public static void moveDown(int roundCnt) {
        if(roundCnt == 10) { return; }

        int redDist = 0;    int blueDist = 0;
        int redFlag = 0;    int blueFlag = 0;   //구멍에 빠지면 1
        //빨간 구슬과 파란 구슬의 마지막 위치 구하기
        for(int i=redMarble.row+1; i<N; i++) {
            if(board[i].charAt(redMarble.col) == 'O') {
                redFlag = 1;    break;
            } else if(board[i].charAt(redMarble.col) == '#') {
                break;
            } else {
                redDist++; continue;
            }
        }
        for(int i=blueMarble.row+1; i<N; i++) {
            if(board[i].charAt(blueMarble.col) == 'O') {
                blueFlag = 1;   break;
            } else if(board[i].charAt(blueMarble.col) == '#') {
                break;
            } else {
                blueDist++; continue;
            }
        }

        //구멍에 빠진 구슬이있으면 확인하기
        if(blueFlag == 1) { return; }
        if(redFlag == 1) {
            if(tempAnswer == INFI) { tempAnswer = roundCnt; }
            else {
                if(tempAnswer > roundCnt) { tempAnswer = roundCnt; }
            }
            return;
        }

        //둘의 최종 위치 저장하기
        if((redMarble.row + redDist != blueMarble.row + blueDist) || (redMarble.col != blueMarble.col)) {   //둘의 최종 위치가 다르면 그대로 저장
            redMarble.row += redDist;
            blueMarble.row += blueDist;
        } else {
            if(redDist < blueDist) {
                redMarble.row += redDist;
                blueMarble.row = redMarble.row - 1;
            } else {
                blueMarble.row += blueDist;
                redMarble.row = blueMarble.row - 1;
            }
        }

        //원래 위치 저장
        RedMarble tempRedMarble = new RedMarble(redMarble.row, redMarble.col);
        BlueMarble tempBlueMarble = new BlueMarble(blueMarble.row, blueMarble.col);

        moveUp(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveLeft(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveRight(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;
    }

    public static void moveLeft(int roundCnt) {
        if(roundCnt == 10) { return; }

        int redDist = 0;    int blueDist = 0;
        int redFlag = 0;    int blueFlag = 0;   //구멍에 빠지면 1
        //빨간 구슬과 파란 구슬의 마지막 위치 구하기
        for(int j=redMarble.col-1; j>= 0; j--) {
            if(board[redMarble.row].charAt(j) == 'O') {
                redFlag = 1;    break;
            } else if(board[redMarble.row].charAt(j) == '#') {
                break;
            } else {
                redDist++; continue;
            }
        }
        for(int j=blueMarble.col-1; j>=0; j--) {
            if(board[blueMarble.row].charAt(j) == 'O') {
                blueFlag = 1;   break;
            } else if(board[blueMarble.row].charAt(j) == '#') {
                break;
            } else {
                blueDist++; continue;
            }
        }

        //구멍에 빠진 구슬이있으면 확인하기
        if(blueFlag == 1) { return; }
        if(redFlag == 1) {
            if(tempAnswer == INFI) { tempAnswer = roundCnt; }
            else {
                if(tempAnswer > roundCnt) { tempAnswer = roundCnt; }
            }
            return;
        }

        //둘의 최종 위치 저장하기
        if((redMarble.col - redDist != blueMarble.col - blueDist) || (redMarble.row != blueMarble.row)) {   //둘의 최종 위치가 다르면 그대로 저장
            redMarble.col -= redDist;
            blueMarble.col -= blueDist;
        } else {
            if(redDist < blueDist) {
                redMarble.col -= redDist;
                blueMarble.col = redMarble.col + 1;
            } else {
                blueMarble.col -= blueDist;
                redMarble.col = blueMarble.col + 1;
            }
        }

        //원래 위치 저장
        RedMarble tempRedMarble = new RedMarble(redMarble.row, redMarble.col);
        BlueMarble tempBlueMarble = new BlueMarble(blueMarble.row, blueMarble.col);

        moveUp(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveDown(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveRight(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

    }

    public static void moveRight(int roundCnt) {
        if(roundCnt == 10) { return; }

        int redDist = 0;    int blueDist = 0;
        int redFlag = 0;    int blueFlag = 0;   //구멍에 빠지면 1
        //빨간 구슬과 파란 구슬의 마지막 위치 구하기
        for(int j=redMarble.col+1; j<M; j++) {
            if(board[redMarble.row].charAt(j) == 'O') {
                redFlag = 1;    break;
            } else if(board[redMarble.row].charAt(j) == '#') {
                break;
            } else {
                redDist++; continue;
            }
        }
        for(int j=blueMarble.col+1; j<M; j++) {
            if(board[blueMarble.row].charAt(j) == 'O') {
                blueFlag = 1;   break;
            } else if(board[blueMarble.row].charAt(j) == '#') {
                break;
            } else {
                blueDist++; continue;
            }
        }

        //구멍에 빠진 구슬이있으면 확인하기
        if(blueFlag == 1) { return; }
        if(redFlag == 1) {
            if(tempAnswer == INFI) { tempAnswer = roundCnt; }
            else {
                if(tempAnswer > roundCnt) { tempAnswer = roundCnt; }
            }
            return;
        }

        //둘의 최종 위치 저장하기
        if((redMarble.col + redDist != blueMarble.col + blueDist) || (redMarble.row != blueMarble.row)) {   //둘의 최종 위치가 다르면 그대로 저장
            redMarble.col += redDist;
            blueMarble.col += blueDist;
        } else {
            if(redDist < blueDist) {
                redMarble.col += redDist;
                blueMarble.col = redMarble.col - 1;
            } else {
                blueMarble.col += blueDist;
                redMarble.col = blueMarble.col - 1;
            }
        }

        //원래 위치 저장
        RedMarble tempRedMarble = new RedMarble(redMarble.row, redMarble.col);
        BlueMarble tempBlueMarble = new BlueMarble(blueMarble.row, blueMarble.col);

        moveUp(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveDown(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveLeft(roundCnt+1);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //입력
        N = scanner.nextInt();  M = scanner.nextInt();
        board = new String[N];

        scanner.nextLine(); //개행문자 처리
        for(int i=0; i<N; i++) {
            String str = scanner.nextLine();
            board[i] = str;
            for(int j=0; j<M; j++) {
                if(str.charAt(j) == 'R') {
                    redMarble = new RedMarble(i, j);
                }
                if(str.charAt(j) == 'B') {
                    blueMarble = new BlueMarble(i, j);
                }
            }
        }

        //원래 위치 저장
        RedMarble tempRedMarble = new RedMarble(redMarble.row, redMarble.col);
        BlueMarble tempBlueMarble = new BlueMarble(blueMarble.row, blueMarble.col);

        moveUp(0);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveDown(0);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveLeft(0);
        //위치 원복
        redMarble.row = tempRedMarble.row;  redMarble.col = tempRedMarble.col;
        blueMarble.row = tempBlueMarble.row;    blueMarble.col = tempBlueMarble.col;

        moveRight(0);

        if(tempAnswer == INFI) {
            System.out.println("-1");
        } else {
            System.out.println(tempAnswer+1);
        }
    }
}
