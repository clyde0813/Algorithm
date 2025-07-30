import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++) {
            if(i<k || pq.peek() < score[i]) {
                if(pq.size() >= k) pq.poll();
                pq.offer(score[i]);
            }
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}