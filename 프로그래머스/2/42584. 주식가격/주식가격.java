import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
    
        int idx =-1;
        for(int i=0; i<n; i++) {
            if(idx!=-1 && prices[i]<prices[stack[idx]]) {
                while(idx!=-1 && prices[i]<prices[stack[idx]]) 
                    answer[stack[idx]] = i-stack[idx--];
            }
            stack[++idx] = i;
        }
        
        for(int i=0; i<n; i++) {
            if(answer[i]==0) answer[i] = n - i - 1;
        }
        
        return answer;
    }
}