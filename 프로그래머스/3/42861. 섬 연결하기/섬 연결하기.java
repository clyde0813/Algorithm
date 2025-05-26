import java.util.*;

class Solution {
    private int[] parent;
    public int solution(int n, int[][] costs) {
        this.parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        int totalCost = 0;
        int edgesUsed = 0;
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(int[] cost : costs){
            int x = cost[0], y = cost[1], c = cost[2];
            if(find(x) != find(y)){
                union(x, y);
                totalCost += c;
                edgesUsed++;
                if(edgesUsed == n-1) break;
            }
        }
        
        return totalCost;
    }
    
    private int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);
        parent[yParent] = xParent;
    }
}