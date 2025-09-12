import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        
        for(int q : queue1) sum1 += q;
        for(int q : queue2) sum2 += q;
        
        long total = sum1 + sum2;
        
        if(total % 2 == 1) return -1;
        long target = total / 2;
        
        int[] arr = new int[n * 2];
        System.arraycopy(queue1, 0, arr, 0, n);
        System.arraycopy(queue2, 0, arr, n, n);
        
        int i=0, j=n;
        
        int moves = 0;
        int limit = 3*n;
        
        while(moves <= limit) {
            if(sum1 == target) return moves;
            
            if(sum1 < target) {
                sum1 += arr[j % (2*n)];
                j++;
            }
            else if(sum1 > target) {
                sum1 -= arr[i % (2*n)];
                i++;
            }
            
            moves++;
        }
        
        return -1;
    }
}