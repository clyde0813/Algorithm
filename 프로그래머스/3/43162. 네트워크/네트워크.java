import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int[] parents = new int[n];
        for(int i=0; i<n; i++) parents[i] = i;
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(computers[i][j]==0) continue;
                if(find(parents, i)==find(parents, j)) continue;
                union(parents, i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int p : parents) set.add(find(parents, p));
        
        return set.size();
    }
    
    private int find(int[] parents, int target){
        if(parents[target]!=target) parents[target] = find(parents, parents[target]);
        return parents[target];
    }
    
    private void union(int[] parents, int target, int child){
        parents[find(parents, child)] = find(parents, target);
    }
}