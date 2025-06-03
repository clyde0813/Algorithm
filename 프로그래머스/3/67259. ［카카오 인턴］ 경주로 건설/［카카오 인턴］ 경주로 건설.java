import java.util.*;

class Solution {
    private int n;
    private int[][] board;
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int solution(int[][] board) {
        this.board = board;
        this.n = board.length;
        int[][][] map = new int[n][n][4];
        for(int[][] mm : map) for(int[] m : mm) Arrays.fill(m, Integer.MAX_VALUE);
        
        //{y좌표, x좌표, 이전방향, 누적값}
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[3]-o2[3]);
        queue.offer(new int[]{0, 0, -1, 0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int y = curr[0], x = curr[1], direction = curr[2], cost = curr[3];
            
            for(int i=0; i<4; i++){
                int[] dir = dirs[i];
                int dy = y+dir[0], dx = x+dir[1];
                if(!isInBountAndRoad(dy, dx)) continue;
                
                int newCost = cost + 100;
                if(direction!=-1 && direction!=i) newCost += 500;
                if(map[dy][dx][i] <= newCost) continue;
                
                map[dy][dx][i] = newCost;
                queue.offer(new int[]{dy, dx, i, newCost});
            }
        }

        return Arrays.stream(map[n-1][n-1]).min().getAsInt();
    }
    
    private boolean isInBountAndRoad(int y, int x){
        return n>y && y>=0 && n>x && x>=0 && board[y][x]==0;
    }    
}