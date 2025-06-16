import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        
        for(int i=0; i<n; i++) {
            int[] query = queries[i];
            int value = Integer.MAX_VALUE, s = query[0], e = query[1], k = query[2]; 
            for(int j=s; j<=e; j++){
                if(arr[j]>k) value = Math.min(arr[j], value);
            }
            if(value == Integer.MAX_VALUE) answer[i] = -1;
            else answer[i] = value;
        }

        return answer;
    }
}