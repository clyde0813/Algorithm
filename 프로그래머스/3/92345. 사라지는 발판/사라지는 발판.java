import java.util.*;

class Solution {
    private static int[][] board;
    private static int m, n;
    private static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.n = board.length;
        this.m = board[0].length;
        
        return dfs(aloc, bloc);
    }
    
    private static int dfs(int[] current, int[] next) {
        int y = current[0], x = current[1];
        if(!isValid(y, x)) return 0;
        
        int ret = 0;
        board[y][x] = 0;
        for(int[] dir : dirs) {
            int dy = y+dir[0], dx = x+dir[1];
            if(!isValid(dy, dx)) continue;
            
            int cnt = 1 + dfs(next, new int[]{dy, dx});
            
            if(ret%2==0) {
                if(cnt%2==0) ret = Math.max(ret, cnt);
                else ret = cnt;
            }
            else {
                if(cnt%2==1) ret = Math.min(ret, cnt);
            }
        }
		board[y][x] = 1;
        
        return ret;
    }
    
    private static boolean isValid(int y, int x) {
        return m>x && x>=0 && n>y && y>=0 && board[y][x] == 1;
    }
}