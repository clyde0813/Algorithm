import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        if(N==1) return 1;
        
        List<int[]>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        for(int[] r : road) for(int i=0; i<2; i++) graph[r[i]-1].add(new int[]{r[i]-1, r[1-i]-1, r[2]});
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.addAll(graph[0]);
        
        int[] cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        
        int answer = 1;
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int parent = current[0], child = current[1], value = current[2];
            int currentCost = cost[parent] + value;
            
            if(currentCost<=K && currentCost<cost[child]) {
                if(cost[child]==Integer.MAX_VALUE) answer++;
                cost[child] = currentCost;
                pq.addAll(graph[child]);
            }
        }

        return answer;
    }
}