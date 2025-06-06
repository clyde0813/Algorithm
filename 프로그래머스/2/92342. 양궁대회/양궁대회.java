import java.util.*;

class Solution {
    private static int[] answer = new int[11];
    private static int maxScoreDiff = 0;
    private static int n;
    private static int[] info;

    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        
        dfs(0, n, new int[11]);
        
        if(maxScoreDiff==0) return new int[]{-1};
        return answer;
    }
    
    private static void dfs(int idx, int remain, int[] ryan) {
        if(idx==11) {
            int scoreDiff = getScoreDiff(ryan);
            
            if(scoreDiff<maxScoreDiff) return;
            if(scoreDiff==maxScoreDiff){
                for(int i=10; i>=0; i--){
                    if(ryan[i]>answer[i]) break;
                    if(ryan[i]<=answer[i] && remain>0) break;
                    if(ryan[i]<answer[i]) return;
                }
            }
            
            answer = ryan.clone();
            answer[10] += remain;
            maxScoreDiff = scoreDiff;

            return;
        }
        

        dfs(idx+1, remain, ryan);
        
        int need = info[idx]+1;
        if(remain>=need) {
            ryan[idx] = need;
            dfs(idx+1, remain-need, ryan);
            ryan[idx] = 0;
        }
        return;
}
    
    private static int getScoreDiff(int[] ryan) {
        int value = 0;
        for(int i=0; i<10; i++) {
            if(info[i]+ryan[i]==0) continue;
            
            if(info[i]<ryan[i]) value += 10-i;
            else value -= 10-i;
        }
        return value;
    }
}