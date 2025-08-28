import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int[] visited = new int[1000000];
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
            });
        queue.offer(new int[]{x, 0});
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int value = temp[0];
            int cost = temp[1];
            
            if(value > y) return -1;
            if(value == y) return cost;
            if(visited[value] != 0 && visited[value] <= cost) continue;
            
            visited[value] = cost++;
            queue.offer(new int[]{value + n, cost});
            queue.offer(new int[]{value * 2, cost});
            queue.offer(new int[]{value * 3, cost});
        }
        
        return -1;
    }
}