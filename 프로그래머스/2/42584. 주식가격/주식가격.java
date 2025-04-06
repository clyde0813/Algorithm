import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
		return solutionWithDeque(prices);
    }
    
    public int[] solutionWithDeque(int[] prices){
        int n = prices.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[n];
        
        for(int i = 0; i<n; i++){
            if(!deque.isEmpty() && prices[deque.peek()] > prices[i]){
                while(!deque.isEmpty() && prices[deque.peek()] > prices[i]){
                    int last = deque.pop();
                    answer[last] = i - last;
                }
            } 
            deque.push(i);
        }
        
        for(int i = 0; i<n-1; i++){
            if(answer[i] == 0) answer[i] = n - 1 - i;
        }
        
        return answer;
    }
}