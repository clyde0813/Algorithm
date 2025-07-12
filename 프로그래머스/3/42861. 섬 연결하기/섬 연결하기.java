import java.util.*;

class Solution {
    private int[] root;
    
    public int solution(int n, int[][] costs) {
        if(n==1) return 0;
        
        this.root = new int[n];
        for(int i=0; i<n; i++) root[i] = i;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        int answer = 0;
        for(int[] cost : costs) {
            if(find(cost[0]) == find(cost[1])) continue;
            
            int parent = Math.min(cost[0], cost[1]);
            int child = Math.max(cost[0], cost[1]);
            union(parent, child);
            answer += cost[2];
        }
        
        return answer;
    }
    
    private int find(int node) {
        if(root[node] != node) root[node] = find(root[node]);
        return root[node];
    }
    
    private void union(int parent, int child) {
        int parentRoot = find(parent);
        int childRoot = find(child);
        root[childRoot] = parentRoot;        
    }
}