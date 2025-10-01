import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {        
        int sum = sequence[sequence.length-1];
        int start = sequence.length-1;
        int end = sequence.length-1;
        
        while(true) {
            if(sum == k) {
                if(start-1 >= 0 && (sequence[end] == sequence[start-1])) {
                    end--;
                    start--;
                    continue;
                }
                break;
            }
            if(sum < k) {
                sum += sequence[--start];
            }
            if(sum > k) {
                sum -= sequence[end--];
            }
        }
        
        int[] answer = new int[]{start, end};
        return answer;
    }    
}