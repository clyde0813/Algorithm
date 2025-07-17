import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        for(int[] r : road) {
            graph[r[0]-1].add(new int[]{r[1]-1, r[2]});
            graph[r[1]-1].add(new int[]{r[0]-1, r[2]});
        }

        int[] cost = new int[N];
        for(int i=0; i<N; i++) cost[i] = Integer.MAX_VALUE;
        cost[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{0, 0});
        
        int answer = 1;
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], value = current[1];
            
            for(int[] g : graph[node]) {
                if(value+g[1]>cost[g[0]] || value+g[1]>K) continue;
                if(cost[g[0]]==Integer.MAX_VALUE) answer++;
                
                cost[g[0]] = value + g[1];
                pq.offer(new int[]{g[0], value + g[1]});
            }
        }
            
        return answer;
    }
}