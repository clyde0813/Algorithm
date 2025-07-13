import java.util.*;
import java.util.stream.*;

class Solution {
    private int[] parent;
    
    public int solution(int n, int[][] computers) {
        this.parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        
        int answer = 0;
        for(int i=0; i<n; i++) {
            int[] connections = computers[i];
            for(int j=0; j<n; j++) {
                if(i==j || connections[j]==0) continue;
                
                if(find(i) != find(j)) union(i, j);
            }
        }
        for(int i=0; i<n; i++) find(i);
        
        Set<Integer> set = new HashSet<>(Arrays.stream(parent).boxed().collect(Collectors.toList()));

        return set.size();
    }
    
    private int find(int node) {
        if(parent[node] != node) parent[node] = parent[find(parent[node])];
        return parent[node];
    }
    
    private void union(int node1, int node2) {
        parent[find(node1)] = find(node2); 
    }
}