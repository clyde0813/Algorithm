import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();

        for(char c : number.toCharArray()) {
            while(k>0 && !deque.isEmpty() && deque.peekLast() < c) {
                deque.pollLast();
                k--;
            }
            deque.offer(c);
        }
        
        for(int i=0; i<k; i++) deque.pollLast();
        
        StringBuilder answer = new StringBuilder();
        for(char c : deque) answer.append(c);
        
        return answer.toString();
    }
}