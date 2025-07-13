import java.util.*;

class Solution {
    private int n, m;
    private int[][] maps;
    private boolean[][] visited;
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public int solution(int[][] maps) {
        this.n = maps.length;
        this.m = maps[0].length;
        this.maps = maps;
        this.visited = new boolean[n][m];
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerFirst(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!deque.isEmpty()) {
            int[] curr = deque.pollLast();
            int y = curr[0], x = curr[1], count = curr[2];
            if(y==n-1&&x==m-1) return count;

            for(int[] dir : dirs) {
                int dy = y+dir[0], dx = x+dir[1];
                if(!isInBound(dy, dx)) continue;
                if(!isAvailable(dy, dx)) continue;
                visited[dy][dx] = true;
                deque.offerFirst(new int[]{dy, dx, count+1});
            }
        }
        
        return -1;
    }
    
    private boolean isInBound(int y, int x) {
        return n>y && y>=0 && m>x && x>=0;
    }
    
    private boolean isAvailable(int y, int x) {
        return maps[y][x]!=0 && !visited[y][x];
    }
}