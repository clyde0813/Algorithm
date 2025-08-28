import java.util.*;

class Solution {
    private int y, n;
    private Queue<Integer> queue = new ArrayDeque<>();
    private int[] visitedCount = new int[1_000_000 + 1];
    
    public int solution(int x, int y, int n) {
        this.y = y;
        this.n = n;
        queue.offer(x);
        
        while(!queue.isEmpty()) {
            int value = queue.poll();
            if(value == y) return visitedCount[value];
            
            offerQueue(value, value+n);
            offerQueue(value, value*2);
            offerQueue(value, value*3);
        }
        
        return -1;
    }
    
    private void offerQueue(int value, int nextValue) {
        if(nextValue <= y && visitedCount[nextValue] == 0) {
            queue.offer(nextValue);
            visitedCount[nextValue] = visitedCount[value] + 1;
        }
        return;
    }
}