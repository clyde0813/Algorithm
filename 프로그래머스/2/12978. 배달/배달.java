import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N];
        
        for(int i=0; i<N; i++) graph[i] = new ArrayList<>();
        
        for(int[] r : road){
            graph[r[0]-1].add(new int[]{r[1]-1, r[2]});
            graph[r[1]-1].add(new int[]{r[0]-1, r[2]});
        }
        
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[0] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{0, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cur = curr[0];
            for(int[] next : graph[cur]){
                if(dist[cur] + next[1] > dist[next[0]]) continue;
                
                dist[next[0]] = dist[cur] + next[1]; 
                pq.add(next);
            }
        }
        
        int answer = 0;
        for(int d : dist){
            if(d<=K) answer++;
        }
        
        return answer;
    }
}