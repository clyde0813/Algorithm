import java.util.*;

class Solution {
    private int score;
    private int[] apeach;
    private int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        this.apeach = info;
        
        dfs(n, 0, new int[11]);
        
        return answer;
    }
    
    private void dfs(int n, int idx, int[] ryan) {
        if(n==0) {
            getScore(ryan);
            return;
        }
        
        for(int i=idx; i<11; i++) {
            int require = (i==10) ? n : apeach[i]+1;
            if(n < require) continue;
            
            ryan[i] = require;
            dfs(n-require, i+1, ryan);
            ryan[i] = 0;
        }
        return;
    }
    
    private void getScore(int[] ryan) {
        int result = 0;
        for(int i=0; i<11; i++) {
            if(apeach[i] + ryan[i] == 0) continue;
            result += (apeach[i] < ryan[i]) ? (10-i) : -(10-i);
        }
                
        if(result==score && score!=0) {
            for(int i=10; i>=0; i--) {
                if(ryan[i] == answer[i]) continue;
                
                if(ryan[i] > answer[i]) {
                    answer = ryan.clone();
                    score = result;
                    break;
                } else break;
            }   
        }
        else if(result > score){
            answer = ryan.clone();
            score = result;
        } 
        return;
    }
}