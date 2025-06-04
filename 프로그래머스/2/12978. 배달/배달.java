import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        if(N==1) return 1;
        
        List<int[]>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        for(int[] r : road){
            graph[r[0]-1].add(new int[]{r[1]-1, r[2]});
            graph[r[1]-1].add(new int[]{r[0]-1, r[2]});
        }
        
        int[] costs = new int[N];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{0,0});
        
        int answer = 1;
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0], cost = current[1];
            
            for(int[] next : graph[node]){
                if(cost+next[1]>K || costs[next[0]]<cost+next[1]) continue;
                
                if(costs[next[0]]==Integer.MAX_VALUE) answer++;
                costs[next[0]] = cost+next[1];
                pq.offer(new int[]{next[0], cost+next[1]});
            }
        }
        

        return answer;
    }
}