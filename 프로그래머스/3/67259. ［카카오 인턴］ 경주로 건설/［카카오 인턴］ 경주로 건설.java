import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        int[][][] map = new int[n][m][4];
        for(int i=0; i<n; i++) for(int j=0; j<m; j++) Arrays.fill(map[i][j], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.offer(new int[]{0, 0, 0, -1});

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int y = current[0], x = current[1], cost = current[2], direction = current[3];

            for(int i=0; i<4; i++) {
                int[] dir = dirs[i];
                int dy = y+dir[0], dx = x+dir[1];

                if(!(n>dy&&dy>=0&&m>dx&&dx>=0) || board[dy][dx]==1) continue;

                int value = cost + ((direction == i || direction==-1) ? 100 : 600);
                if(value >= map[dy][dx][i]) continue;
                map[dy][dx][i] = value;
                pq.add(new int[]{dy, dx, value, i});
            }
        }
        
        return Arrays.stream(map[n-1][m-1]).min().getAsInt();
    }
}