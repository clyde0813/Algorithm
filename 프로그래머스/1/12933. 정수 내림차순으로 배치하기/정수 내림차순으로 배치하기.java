import java.util.*;

class Solution {
    public long solution(long n) {
        List<Integer> digits = new ArrayList<>();
        
        while(n>0) {
            digits.add((int) (n%10));
            n /= 10;
        }
        
        digits.sort(Collections.reverseOrder());
        
        long answer = 0;
        for(int d : digits) answer = answer * 10 + d;
        return answer; 
    }
}