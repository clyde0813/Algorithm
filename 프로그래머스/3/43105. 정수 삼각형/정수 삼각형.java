import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int[] dp = new int[triangle.length];
        dp[0] = triangle[0][0];
        
        for(int i=0; i<triangle.length-1; i++) {
            int past = 0;
            for(int j=0; j<triangle[i].length; j++) {
                int tmp = dp[j];
                dp[j] = Math.max(past, dp[j]+triangle[i+1][j]);
                past = tmp + triangle[i+1][j+1];
            }
            dp[triangle[i].length] = past;            
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}