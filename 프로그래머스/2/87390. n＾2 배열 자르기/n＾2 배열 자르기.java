import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right-left+1)];
        
        for(long i=left; i<=right; i++) {
            int start = (int) (i/n);
            int idx = (int) (i-left);
            if(i%n <= start) answer[idx] = start+1;
            else answer[idx] = (start+1) + (int) ((i%n)-start);
        }
                
        return answer;
    }
}