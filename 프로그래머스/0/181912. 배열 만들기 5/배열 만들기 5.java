import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> result = new ArrayList<>();
        
        for(String str : intStrs) {
            int sub = Integer.valueOf(str.substring(s, s+l));
            if(k < sub) result.add(sub);
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}