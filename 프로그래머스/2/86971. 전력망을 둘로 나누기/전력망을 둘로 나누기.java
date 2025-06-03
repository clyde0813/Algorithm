import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<n-1; i++){            
            int[] parent = new int[n];
            for(int j=0; j<n; j++) parent[j] = j;
            
            for(int j=0; j<n-1; j++){
                if(i==j) continue;
                
                int[] wire = wires[j];
                union(parent, wire[0]-1, wire[1]-1);
            }
            
            for(int j=0; j<n; j++) find(parent, j);

            int key = parent[0];
            int diff = 0;
            for(int j=0; j<n; j++) if(parent[j]!=key) diff++;
            
            answer = Math.min(answer, Math.abs(n-(diff*2)));
        }
        
        return answer;
    }
    
    private int find(int[] parent, int target){
        if(parent[target] != target){
            parent[target] = find(parent, parent[target]);
        }
        return parent[target];
    }
    
    private void union(int[] parent, int a, int b){
        int aParent = find(parent, a);
        int bParent = find(parent, b);
        if(aParent != bParent){
            parent[bParent] = aParent;
        }
    }
}