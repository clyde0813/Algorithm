import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("0");

        for(int i=food.length-1; i>=1; i--) {
            for(int j=0; j<food[i]/2; j++) {
                sb.insert(0, i);
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}