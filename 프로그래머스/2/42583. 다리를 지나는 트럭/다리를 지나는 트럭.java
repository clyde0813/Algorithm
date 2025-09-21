import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<int[]> deque = new ArrayDeque<>();
                
        int time = 0, idx = 0, onBridge = 0, n = truck_weights.length;
        
        while(idx < n || !deque.isEmpty()) {       
            time++;
            
            if(!deque.isEmpty() && deque.peek()[1] == time) {
                onBridge -= deque.poll()[0];
            }
            
            if(idx < n && onBridge + truck_weights[idx] <= weight) {
                onBridge += truck_weights[idx];
                deque.offer(new int[]{truck_weights[idx], time + bridge_length});
                idx++;
            }
            else if(idx < n && !deque.isEmpty()) {
                time = deque.peek()[1] - 1;    
            }
        }
        
        return time;
    }
}