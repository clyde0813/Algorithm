import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {        
        int sum = sequence[sequence.length-1];
        int start = sequence.length-1;
        int end = sequence.length-1;
        
        while(start >= 0 && end >= 0) {
            if(sum == k) {
                if(start > 0 && sequence[start-1] == sequence[end]) {
                    sum += sequence[--start];
                    sum -= sequence[end--];
                    continue;
                } 
                
                break;
            } 
            
            if(sum < k) sum += sequence[--start];
            if(sum > k) sum -= sequence[end--];
        }

        
        int[] answer = new int[]{start, end};
        return answer;
    }    
}