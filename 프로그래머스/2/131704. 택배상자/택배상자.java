import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> stack = new ArrayDeque<>();        
        int nextBox = 1;
        int answer = 0;
        
        for(int target : order) {
            if(target == nextBox) {
                nextBox++;
            }
            else if(!stack.isEmpty() && target == stack.peek()) stack.pop();
            else if(target > nextBox) {
                for(int j=nextBox; j<target; j++) stack.push(j);
                nextBox = target + 1;
            }
            else break;
            answer++;
        }        
        
        return answer;
    }
}