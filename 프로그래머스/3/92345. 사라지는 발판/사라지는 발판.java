import java.util.*;

class Solution {
    private int n, m;
    private int[][] BOARD;
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.BOARD = board;
        this.n = board.length;
        this.m = board[0].length;
                
        return dfs(aloc, bloc);
    }
    
    private int dfs(int[] current, int[] next) {
        int y = current[0], x = current[1];
        if(!isAvailable(y, x)) return 0;
            
        int result = 0;
        BOARD[y][x] = 0;
        for(int[] dir : dirs) {
            int dy = y+dir[0], dx = x+dir[1];
            if(!isAvailable(dy, dx)) continue;
            
            int count = dfs(next, new int[]{dy, dx})+1;
            
            if(result%2==0 && count%2==1) result = count;
            else if(result%2==0 && count%2==0) result=Math.max(result, count);
            else if(result%2==1 && count%2==1) result=Math.min(result, count);
        }
        BOARD[y][x] = 1;
        
        return result;
    }
    
    private boolean isAvailable(int y, int x) {
        return n>y && y>=0 && m>x && x>=0 && BOARD[y][x]==1;
    }
}