import java.util.*;

class Solution {
    private static boolean[][] visited;
    private static int n;
    private static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int solution(int[][] land, int height) {
        this.n = land.length;
        this.visited = new boolean[n][n];
        
        for(boolean[] v : visited) Arrays.fill(v, false);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);
        pq.offer(new int[]{0,0,0});
        
        int answer = 0;
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int y = current[0], x = current[1], cost = current[2];
            if(!isAvailable(y, x)) continue;
            
            answer += cost;
            visited[y][x] = true;
            
            for(int[] dir : dirs) {
                int dy = y+dir[0], dx = x+dir[1];
                if(!isAvailable(dy, dx)) continue;
                
                int diff = Math.abs(land[y][x]-land[dy][dx]);
                int newCost = (diff>height) ? diff : 0;
                pq.offer(new int[]{dy, dx, newCost});
            }
        }
            
        return answer;
    }
    
    private static boolean isAvailable(int y, int x) {
        return n>y && y>=0 && n>x && x>=0 && !visited[y][x];
    }
}