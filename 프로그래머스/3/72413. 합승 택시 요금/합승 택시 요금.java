import java.util.*;

class Solution {
    private Map<Integer, List<int[]>> map = new HashMap<>();
    private int n;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.map = createMap(fares);
        this.n = n;
        
        int[] distS = dijkstra(s);
        int[] distA = dijkstra(a);
        int[] distB = dijkstra(b);
        
        int answer = findOptimalSharedRoute(distS, distA, distB);
            
        return answer;
    }
    
    private Map<Integer, List<int[]>> createMap(int[][] fares) {
        Map<Integer, List<int[]>> result = new HashMap<>();
        
        for(int[] fare : fares) {
            int node1 = fare[0];
            int node2 = fare[1];
            int fee = fare[2];
            
            result.computeIfAbsent(node1, o -> new ArrayList<>())
                .add(new int[]{node2, fee});
            result.computeIfAbsent(node2, o -> new ArrayList<>())
                .add(new int[]{node1, fee});
        }
        
        for (List<int[]> neighbors : result.values()) {
            neighbors.sort((a, b) -> Integer.compare(a[1], b[1]));
        }
        
        return result;
    }
    
    private int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> Integer.compare(i1[1], i2[1]));
        
        boolean[] visited = new boolean[n+1];
        int[] result = new int[n+1];
        
        Arrays.fill(result, Integer.MAX_VALUE);
        pq.offer(new int[]{start, 0});
        
        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int destination = node[0];
            int cost = node[1];
                        
            if(result[destination] <= cost) continue;
            
            result[destination] = cost;
            for(int[] route : map.get(destination)) {                
                pq.offer(new int[]{route[0], cost + route[1]});
            }
        }
        
        return result;
    }
    
    private int findOptimalSharedRoute(int[] dist1, int[] dist2, int[] dist3) {
        int result = Integer.MAX_VALUE;
        
        for(int i=1; i<n+1; i++) {
            result = Math.min(result, dist1[i] + dist2[i] + dist3[i]);
        }
        
        return result;
    }
}