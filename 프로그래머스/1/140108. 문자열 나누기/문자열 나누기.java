import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] arr = s.toCharArray();
        int[] status = new int[3];
        for(int i=0; i<s.length(); i++) {
            char c = arr[i];
            if(status[0]==0) {
                status[0] = c;
                status[1]++;
                continue;
            }
            
            if(status[0]==c) status[1]++;
            else status[2]++;
            
            if(status[1]==status[2]) {
                answer++;
                Arrays.fill(status, 0);
            }
        }
        if(status[0]!=0) answer++;
        
        return answer;
    }
}