import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] bookTime = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i1-i2);
        
        for(int i=0; i<n; i++) {
            bookTime[i] = timeToIntArr(book_time[i]);
        }
        
        Arrays.sort(bookTime, (o1, o2) -> o1[0] - o2[0]);
        
        int answer = 1;
        pq.offer(bookTime[0][1]);
        
        for(int i=1; i<n; i++) {
            int checkIn = bookTime[i][0];
            int checkOut = bookTime[i][1];
            
            if(pq.peek()+10 <= checkIn) pq.poll();
            else answer++;
            
            pq.offer(checkOut);
        }
        
        return answer;
    }
    
    private int[] timeToIntArr(String[] stringTime) {
        int[] result = new int[2];
        
        for(int i=0; i<2; i++) {
            String[] time = stringTime[i].split(":");
            result[i] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
        }

        return result;
    }
}