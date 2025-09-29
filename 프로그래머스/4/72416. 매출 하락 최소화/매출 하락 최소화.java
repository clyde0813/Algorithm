import java.util.*;

class Solution {
    private Map<Integer, List<Integer>> linkMap = new HashMap<>();
    private int[][] dp;
    private int[] sales;
    private int n;
    
    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        this.n = sales.length;
        this.dp = new int[n+1][2];
        
        createLinkMap(links);

        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private void createLinkMap(int[][] links) {        
        for(int[] link : links) {            
            linkMap.computeIfAbsent(link[0], o -> new ArrayList<>())
                .add(link[1]);
        }
    }
    
    private void dfs(int current) {
        dp[current][1] = sales[current-1];
        
        if(!linkMap.containsKey(current)) return;
        
        int sum = 0;
        int minLoss = Integer.MAX_VALUE;
        boolean lossFlag = false;
        for(int employee : linkMap.get(current)) {
            dfs(employee);
            
            dp[current][1] += Math.min(dp[employee][0], dp[employee][1]);
            
            if(dp[employee][0] < dp[employee][1]) {
                sum += dp[employee][0];
                minLoss = Math.min(minLoss, dp[employee][1] - dp[employee][0]);
            }
            else {
                sum += dp[employee][1];
                lossFlag = true;
            }
        }
        
        dp[current][0] += (lossFlag) ? sum : sum + minLoss;
    }
}