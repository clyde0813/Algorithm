import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        return findUnionSolution(n, wires);
        // return dfsSolution(n, wires);
    }
    
    // dfs 풀이
    private int dfsSolution(int n, int[][] wires){
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<n; i++){
            List<Integer>[] graph = new ArrayList[n];
            for(int j=0; j<n; j++) graph[j] = new ArrayList<>();
            
            for(int j=0; j<n-1; j++){
                if(i==j) continue;
                
                int[] wire = wires[j];
                graph[wire[0]-1].add(wire[1]-1);
                graph[wire[1]-1].add(wire[0]-1);
            }

            int count = dfs(graph, new boolean[n], 0);
            answer = Math.min(answer, Math.abs(n-(2*count)));
        }
        
        return answer;
    }
    
    private int dfs(List<Integer>[] graph, boolean[] visited, int node){
        visited[node] = true;
        int count = 1;
        
        for(int g : graph[node]){
            if(visited[g]) continue;
            
            count += dfs(graph, visited, g);
        }
        
        return count;
    }
    
    // find-union 풀이
    private int findUnionSolution(int n, int[][] wires){
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