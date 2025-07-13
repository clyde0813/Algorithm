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
            for(int j=i+1; j<n; j++) {
                if(connections[j]==0) continue;
                
                if(find(i) != find(j)) union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) set.add(find(i));
        
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