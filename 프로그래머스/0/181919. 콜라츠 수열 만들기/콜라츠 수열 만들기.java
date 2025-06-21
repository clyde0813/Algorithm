import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> result = new ArrayList<>();
        
        while(true) {
            result.add(n);
            if(n==1) break;
            if(n%2==0) n = n / 2;
            else n = 3 * n + 1;          
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}