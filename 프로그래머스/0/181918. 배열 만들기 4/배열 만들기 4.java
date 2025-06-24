import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int i = 0;
        Deque<Integer> stk = new ArrayDeque<>();
        
        while(i<arr.length) {
            if(stk.isEmpty()) stk.offerFirst(arr[i++]);
            else if(stk.peekLast()<arr[i]) stk.offerLast(arr[i++]);
            else stk.pollLast();
        }
                
        return stk.stream().mapToInt(o->o).toArray();
    }
}