import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<Integer> pq = new PriorityQueue(
            (o1, o2) -> {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return (Integer.valueOf(s2+s1)).compareTo(Integer.valueOf(s1+s2));
            });
            
        
        for(int n : numbers) pq.add(n);
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) sb.append(pq.poll());
        
        return (sb.toString().charAt(0)=='0') ? "0" : sb.toString();
    }
}