import java.util.*;

class Solution {
    private static int answer;
    private static int[][] dungeons;
    private static int dungeonCount;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) { 
        this.answer = 0;
        this.dungeons = dungeons;
        this.dungeonCount = dungeons.length;
        this.visited = new boolean[dungeonCount]; 
        
        dfs(k, 0);
        
        return answer;
    }
    
    private void dfs(int k, int cnt){        
        for(int i=0; i<dungeonCount; i++){
            if(dungeons[i][0]>k || visited[i]) continue;
            
            visited[i] = true;
            dfs(k-dungeons[i][1], cnt+1);
            visited[i] = false;
            
            answer = Math.max(answer, cnt+1);
        }        
    }
}