import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        
        for(long i=left; i<=right; i++) {
            int start = (int) (i/n);
            if(i%n <= start) answer[(int) (i-left)] = start+1;
            else answer[(int) (i-left)] = (start+1) + (int) ((i%n)-start);
        }
                
        return answer;
    }
}