import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        
        for(int p : priorities) {
            pq.offer(p);
            queue.offer(p);
        }

        int answer = 0;
        while(!queue.isEmpty()) {
            Integer q = queue.poll();
            if(q == pq.peek()) {
                pq.poll();
                location--;
                answer++;
                if(location==-1) break;
            }
            else {
                queue.offer(q);
                location--;
                if(location==-1) location = queue.size()-1;
            }
        }
        
        return answer;
    }
}