import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i<progresses.length; i++){
            deque.add((100 - progresses[i] + speeds[i] - 1) / speeds[i]);
        }
        
        while(!deque.isEmpty()){
            int base = deque.pollFirst();
            int count = 1;
            while(!deque.isEmpty() && deque.peekFirst() <= base){
                deque.pollFirst();
                count++;
            }
            answer.add(count);
        }
                 
        return answer.stream().mapToInt(i -> i).toArray();
    }
}