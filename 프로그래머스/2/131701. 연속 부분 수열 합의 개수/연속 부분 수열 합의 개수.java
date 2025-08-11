import java.util.*;

class Solution {    
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        
        int[] dp = new int[elements.length];
        for(int i=1; i<=elements.length; i++) {
            for(int j=0; j<elements.length; j++) {
                dp[j] += elements[(j+i-1) % elements.length];
                answer.add(dp[j]);
            }
        }
        
        return answer.size();
    }
}