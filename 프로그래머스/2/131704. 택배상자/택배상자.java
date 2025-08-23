import java.util.*;

class Solution {
    public int solution(int[] order) {
        Deque<Integer> sub = new ArrayDeque<>();
        for(int i=1; i<order[0]; i++) sub.offerFirst(i);
        
        int top = order[0]+1;
        int answer = 1;
        for(int i=1; i<order.length; i++) {
            int o = order[i];
            if(o == top) top += 1;
            else if(!sub.isEmpty() && o == sub.peek()) sub.pollFirst();
            else if(o > top) {
                for(int j=top; j<o; j++) sub.offerFirst(j);
                top = o+1;
            }
            else break;
            answer++;
        }        
        
        return answer;
    }
}