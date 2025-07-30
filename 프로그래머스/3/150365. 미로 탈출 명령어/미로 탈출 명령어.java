import java.util.*;

class Solution {
    private int n, m, c, r, k;
    private int[][] dirs = {{1,0},{0,-1},{0,1},{-1,0}};
    private String[] commands = {"d", "l", "r", "u"};
    
    public String solution(int n, int m, int y, int x, int c, int r, int k) {        
        this.n = n;
        this.m = m;
        this.c = c;
        this.r = r;
        this.k = k;
            
        String answer = dfs(y, x, new StringBuilder());
        return (answer==null) ? "impossible" : answer;
    }
    
    private String dfs(int y, int x, StringBuilder route) {
        if(!isAvailable(y, x, k-route.length())) return null;
        if(route.length()==k && y==c && x==r) return route.toString();
        
        for(int i=0; i<4; i++) {
            int[] dir = dirs[i];
            int dy = y+dir[0], dx = x+dir[1];
            if(!isInBound(dy, dx)) continue;

            String result = dfs(dy, dx, route.append(commands[i]));
            if(result != null) return result;
            route.deleteCharAt(route.length()-1);
        }
        
        return null;
    }
    
    private boolean isInBound(int y, int x) {
        return n>=y && y>=1 && m>=x && x>=1;
    }
    
    private boolean isAvailable(int y, int x, int remain) {
        return (
            (Math.abs(y-c)+Math.abs(x-r)) <= remain &&
            (remain - (Math.abs(y-c)+Math.abs(x-r))) % 2 == 0
        );
    }
}