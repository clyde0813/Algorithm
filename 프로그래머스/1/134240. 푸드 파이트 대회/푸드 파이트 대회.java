import java.util.*;

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        
        for(int i=1; i<food.length; i++) {
            for(int j=0; j<food[i]/2; j++) {
                list.add(i);
                sb.append(i);
            }
        }
        sb.append(0);
        for(int i=list.size()-1; i>=0; i--) sb.append(list.get(i));
        
        return sb.toString();
    }
}