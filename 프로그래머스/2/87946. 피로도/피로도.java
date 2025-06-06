import java.util.*;

class Solution {
    private static int[][] dungeons;
    private static int dungeonCount;
    private static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) { 
        this.dungeons = dungeons;
        this.dungeonCount = dungeons.length;
        this.visited = new boolean[dungeonCount]; 
 
        return dfs(k);
    }
    
    private int dfs(int k){        
        int value = 0;
        for(int i=0; i<dungeonCount; i++){
            if(dungeons[i][0]>k || visited[i]) continue;
            
            int temp = 1;
            visited[i] = true;
            temp += dfs(k-dungeons[i][1]);
            visited[i] = false;
            
            value = Math.max(value, temp);
        }
        
        return value;
    }
}