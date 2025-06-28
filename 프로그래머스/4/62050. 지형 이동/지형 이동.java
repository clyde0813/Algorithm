import java.util.*;

class Solution {
    private static int[][] LAND;
    private static boolean[][] visited;
    private static int n;
    private static int height;
    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int solution(int[][] land, int height) {
        this.LAND = land;
        this.n = land.length;
        this.visited = new boolean[n][n];
        this.height = height;
        
        for(boolean[] v : visited) Arrays.fill(v, false);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[3]-o2[3]);
        pq.offer(new int[]{0,0,land[0][0],0});
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int y = current[0], x = current[1], value = current[2], diff = current[3];
            if(!isAvailable(y, x)) continue;
            if(diff>height) answer += diff;
            visited[y][x] = true;
            
            for(int[] dir : dirs) {
                int dy = y+dir[0], dx = x+dir[1];
                if(!isAvailable(dy, dx)) continue;
                
                int nextValue = LAND[dy][dx];
                pq.offer(new int[]{dy, dx, nextValue, Math.abs(value-nextValue)});
            }
        }
            
        return answer;
    }
    
    private static boolean isAvailable(int y, int x) {
        return n>y && y>=0 && n>x && x>=0 && !visited[y][x];
    }
}