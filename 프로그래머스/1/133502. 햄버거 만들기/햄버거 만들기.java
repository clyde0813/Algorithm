import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        
        for(int i : ingredient) {
            if(stack.isEmpty() && i==1) stack.offer(1);
            else if(!stack.isEmpty() && stack.peekLast()==3 && i==1) {
                answer++;
                for(int j=0; j<3; j++) stack.pollLast();
            }
            else if(!stack.isEmpty() && i==1) stack.offer(1);
            else if(!stack.isEmpty() && stack.peekLast()==i-1) stack.offer(i);
            else stack.clear();
        }
        
        return answer;
    }
}