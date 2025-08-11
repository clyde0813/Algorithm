import java.util.*;

class Solution {    
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        int[] ELEMENTS = new int[elements.length * 2];
        for(int i=0; i<elements.length; i++) {
            ELEMENTS[i] = elements[i];
            ELEMENTS[i+elements.length] = elements[i];
        }
        
        int[] dp = new int[elements.length];
        for(int i=1; i<=elements.length; i++) {
            for(int j=0; j<elements.length; j++) {
                dp[j] += ELEMENTS[j+i-1];
                answer.add(dp[j]);
            }
        }
        
        return answer.size();
    }
}