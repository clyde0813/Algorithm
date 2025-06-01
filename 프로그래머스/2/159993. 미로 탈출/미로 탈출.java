import java.util.*;

class Solution {
    private int[][] map;
    private int n, m;
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int solution(String[] maps) {
        int[] start = new int[2];
        int[] lever = new int[2]; 
        int[] exit = new int[2];
        
        this.n = maps.length;
        this.m = maps[0].length();
        this.map = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int value = 0;
                int chr = maps[i].charAt(j);
                
                if(chr=='X') value = 1;
                else if(chr=='S') start = new int[]{i, j};
                else if(chr=='L') lever = new int[]{i,j};
                else if(chr=='E') exit = new int[]{i, j};
                
                this.map[i][j] = value;
            }
        }
        
        int startToLever = bfs(start, lever);
        int leverToExit = bfs(lever, exit);
        
        if(startToLever==-1 || leverToExit==-1) return -1;
        
        return startToLever + leverToExit;
    }
    
    private int bfs(int[] start, int[] end){
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int y = q[0], x = q[1], v = q[2];

            if(y==end[0] && x==end[1]) return v;
            
            for(int[] dir : dirs){
                int dy = y+dir[0];
                int dx = x+dir[1];
                
                if(!isInBound(dy, dx)) continue;
                if(map[dy][dx]==1) continue;
                if(visited[dy][dx]) continue;
                
                visited[dy][dx] = true;
                queue.offer(new int[]{dy, dx, v+1});
            }
        }
        
        return -1;
    }
    
    private boolean isInBound(int y, int x){
        return n>y && y>=0 && m>x && x>=0;
    }
}