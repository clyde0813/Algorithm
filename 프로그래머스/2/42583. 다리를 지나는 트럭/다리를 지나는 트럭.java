import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<int[]> deque = new ArrayDeque<>();
                
        int time = 0, idx = 0, sum = 0, count = 0;
        
        while(count < truck_weights.length) {       
            time++;
            if(deque.size() == bridge_length) {
                int[] truck = deque.poll();
                sum -= truck[0];
                time = truck[1];
                count++;
            }
            else if(!deque.isEmpty() && deque.peek()[1] == time) {
                sum -= deque.poll()[0];
                count++;
            }
            
            if(idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                sum += truck_weights[idx];
                deque.offer(new int[]{truck_weights[idx], time + bridge_length});
                idx++;
            }
        }
        
        return time;
    }
}