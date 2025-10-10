import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int n = num_list.length;
        int[] answer = new int[n];
        
        for(int i=n-1; i>=0; i--) {
            answer[n-i-1] = num_list[i]; 
        }
        
        return answer;
    }
}