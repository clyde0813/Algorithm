import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps[0].length;
        int m = maps.length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] visited = new boolean[m][n];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int y = curr[0], x = curr[1], v = curr[2];
            
            if(y==m-1&&x==n-1) return v;
            
            for(int[] dir : dirs){
                int ny = y+dir[0], nx = x+dir[1];
                if(m<=ny||ny<0||n<=nx||nx<0) continue;
                if(visited[ny][nx]||maps[ny][nx]==0) continue;
                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx, v+1});   
            }
        }
        
        return -1;
    }
}