import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();
        int INF = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>(Arrays.asList(strs));
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        
        for(int i=1; i<=n; i++) {
            for(int k=1; k<=5 && i-k>=0; k++) {
                if(dp[i-k]==INF) continue;
                if(!set.contains(t.substring(i-k, i))) continue;
                
                dp[i] = Math.min(dp[i], dp[i-k]+1);
            }
        }
        
        return (dp[n]==INF) ? -1 : dp[n];
    }
}