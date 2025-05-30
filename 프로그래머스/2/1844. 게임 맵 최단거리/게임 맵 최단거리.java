import java.util.*;

class Solution {
    private int answer = 1;
    private int[][] maps;
    private int[][] visited;
    private int n, m;
    private int[][] dirs = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    
    public int solution(int[][] maps) {
        this.maps = maps;
        this.n = maps[0].length;
        this.m = maps.length;
        this.visited = new int[m][n];
        bfs(0, 0, 1);
        return (maps[m-1][n-1]==1) ? -1 : maps[m-1][n-1];
    }
    
    private void bfs(int y, int x, int value){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{y, x, value});
        while(!deque.isEmpty()){
            int[] position = deque.pollLast();
            y = position[0];
            x = position[1];
            value = position[2];
            
            if(!isInBound(y, x) || maps[y][x]==0 || visited[y][x]==1) continue;
            
            visited[y][x] = 1;
            maps[y][x] = value++;
            
            for(int[] dir : dirs){
                deque.addFirst(new int[]{y+dir[0], x+dir[1], value});
            }
        }
    }
    
    private boolean isInBound(int y, int x){
        return m>y && y>=0 && n>x && x>=0;
    }
}