import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(0);
        
        for(int i=1; i<numbers.length; i++) {
            int n = numbers[i];
            
            if(numbers[deque.peek()] >= n) {
                deque.offerFirst(i);
                continue;
            }
            
            while(!deque.isEmpty()) {
                int temp = numbers[deque.peek()];
                if(temp >= n) break;
                if(temp < n) answer[deque.pollFirst()] = n;
            }
            deque.offerFirst(i);
        }
        
        while(!deque.isEmpty()) answer[deque.pollFirst()] = -1;
        
        return answer;
    }
}