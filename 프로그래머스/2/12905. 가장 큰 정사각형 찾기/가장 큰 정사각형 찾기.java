import java.util.*;

class Solution {
    private int[][] board;
    private int n, m;
    private int[][] dirs = {{-1,-1}, {-1,0}, {0,-1}};
    
    public int solution(int[][] board) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        
        int side = 0;
        
        for(int y=0; y<n; y++) {
            for(int x=0; x<m; x++) {
                if(board[y][x]==0) continue;
                if(isInSquare(y, x)) board[y][x] = findMinValue(y, x) + 1;
                side = Math.max(side, board[y][x]);
            }
        } 
        
        return side * side;
    }
    
    private boolean isInSquare(int y, int x) {
        if(y==0||x==0) return false;
        
        for(int[] dir : dirs) {
            if(board[y + dir[0]][x + dir[1]]==0) return false;
        }
        return true;
    }
    
    private int findMinValue(int y, int x) {
        int value = Integer.MAX_VALUE;
        for(int[] dir : dirs) {
            value = Math.min(value, board[y + dir[0]][x + dir[1]]);
        }
        return value;
    }
}