import java.util.*;

class Solution {
    private int[] parent;
    
    public int solution(int n, int[][] costs) {
        this.parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        Arrays.sort(costs, (c1, c2) -> c1[2]-c2[2]);
        
        int answer = 0;
        for(int[] cost : costs) {
            if(find(cost[0])==find(cost[1])) continue;
            union(cost[0], cost[1]);
            answer += cost[2];
        }
        
        return answer;
    }
    
    private int find(int node) {
        if(parent[node]!=node) parent[node] = find(parent[node]);
        return parent[node];
    }
    
    private void union(int node1, int node2) {
        parent[find(node1)] = find(node2);
    }
}