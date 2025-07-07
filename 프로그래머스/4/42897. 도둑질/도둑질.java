import java.util.*;

class Solution {
    private int[] money;
    
    public int solution(int[] money) {
        this.money = money;
        int n = money.length;
                
        int case1 = robLinear(0, n-2);
        int case2 = robLinear(1, n-1);
        
        return Math.max(case1, case2);
    }
    
    private int robLinear(int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        
        for(int i=start; i<=end; i++) {
            int cur = Math.max(prev1, prev2 + money[i]);
            prev2 = prev1;
            prev1 = cur;
        }
        
        return prev1;
    }
}