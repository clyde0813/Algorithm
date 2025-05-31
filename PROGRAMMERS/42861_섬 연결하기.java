import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        if(n==1) return 0;
        
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int answer = 0;
        int edges = 0;
        for(int[] cost : costs){
            if(find(parent, cost[0]) == find(parent, cost[1])) continue;
            
            union(parent, cost[0], cost[1]);
            answer += cost[2];
            edges++;
            if(edges == n-1) break;
        }
        return answer;
    }
    
    private int find(int[] parent, int target){
        if(parent[target] != target){
            parent[target] = find(parent, parent[target]);
        }
        return parent[target];
    }
    
    private void union(int[] parent, int target, int child){
        parent[find(parent, child)] = find(parent, target);
    }
}