import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int n = priorities.length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<n; i++) queue.offer(new int[]{i, priorities[i]});
        
        int answer = 0;
        while(!queue.isEmpty()) {
            int[] q = queue.poll();
            
            boolean flag = true;
            for(int[] qq : queue) {
                if(qq[1] > q[1]) {
                    flag = false;
                    queue.offer(q);
                    break;
                }
            }
            
            if(flag) answer ++;
            if(flag && q[0] == location) return answer;
        }
        
        return answer;
    }
}