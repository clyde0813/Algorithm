import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        for(int i=0; i<n; i++){
            if(visited[i]==false){
                dfs(computers, visited, i, n);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int target, int n){
        if(visited[target]==true) return;
        
        visited[target] = true;
        for(int i=0; i<n; i++){
            if(computers[target][i]==1){
                dfs(computers, visited, i, n);
            }
        }
    }
}