import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private Map<Integer, List<Integer>> depth = new HashMap<>();
    private PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
    private boolean[] visited;
    private int maxDepth = 0;
    
    public int solution(int n, int[][] edge) {
        this.visited = new boolean[n+1];
        visited[1] = true;
        
        for(int[] e : edge) {
            graph.computeIfAbsent(e[0], o -> new ArrayList<>()).add(e[1]);
            graph.computeIfAbsent(e[1], o -> new ArrayList<>()).add(e[0]);
        }
        
        pq.add(new int[]{1, 0});
        bfs();
                
        return depth.get(maxDepth).size();
    }
    
    private void bfs() {
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int value = node[0];
            int count = node[1];
            
            depth.computeIfAbsent(count, o -> new ArrayList<>()).add(value);
            maxDepth = Math.max(maxDepth, count); 
            
            for(int n : graph.get(value)) {
                if(visited[n]) continue;
                
                visited[n] = true;
                pq.add(new int[]{n, count+1});
            }
        }
    }
}