import java.io.*;
import java.util.*;

public class Main {
    private static int[][] board;
    
    public static void main(String[] args) throws IOException {
        makeBoard();
        solution();
        printBoard();
    }
    
    private static int[][] makeBoard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for(int y=0; y<9; y++){
            String s = br.readLine();
            for(int x=0; x<9; x++){
                board[y][x] = s.charAt(x) - '0';
            }
        }
        return board;
    }
    
    private static boolean isValid(int num, int y, int x) {
        return !(inRow(num, y) || inCol(num, x) || inBox(num, y, x));
    }
    
    private static boolean inRow(int num, int y) {
        return Arrays.stream(board[y]).anyMatch(n -> n==num);
    }
    
    private static boolean inCol(int num, int x) {
        for(int y=0; y<9; y++) if(board[y][x]==num) return true;
        return false;
    }
    
    private static boolean inBox(int num, int y, int x) {
        int boxY = (y / 3) * 3;
        int boxX = (x / 3) * 3;
        for(int yy=boxY; yy<boxY+3; yy++) {
            for(int xx=boxX; xx<boxX+3; xx++) {
                if(board[yy][xx]==num) return true;
            }
        }
        return false;
    }
    
    private static int[] findEmptyCell() {
        for(int y=0; y<9; y++) {
            for(int x=0; x<9; x++) {
                if(board[y][x]==0) return new int[]{y, x};
            }
        }
        return null;
    }
    
    private static boolean solution() {
        int[] emptyCell = findEmptyCell();
        if(emptyCell==null) return true;
        
        int y = emptyCell[0], x = emptyCell[1];
        for(int i=1; i<=9; i++) {
            if(isValid(i, y, x)) {
                board[y][x] = i;
                if(solution()) return true;
                board[y][x] = 0;
            }
        }  
        return false;
    }
    
    private static void printBoard() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int[] bb : board){
            for(int b : bb){
                bw.write(b + "");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}