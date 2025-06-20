import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(5);
        
        while(!queue.isEmpty()) {
            int current = Integer.valueOf(queue.poll());
            
            if(current>r) break;
            if(current>=l) result.add(current);
            
            queue.add(Integer.valueOf(current + "0"));
            queue.add(Integer.valueOf(current + "5"));
        }
        
        return result.isEmpty() ? new int[]{-1} : result.stream().mapToInt(i -> i).toArray();
    }
}