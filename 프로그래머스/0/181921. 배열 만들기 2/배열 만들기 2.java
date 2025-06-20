import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; ;i++) {
            String binary = Integer.toBinaryString(i);
            StringBuilder sb = new StringBuilder();
            
            for(char c : binary.toCharArray()) sb.append((c=='0') ? "0" : "5");    
            
            int value = Integer.valueOf(sb.toString());
            if(value>r) break;
            else if(value>=l) result.add(value);
        }
        
        return result.isEmpty() ? new int[]{-1} : result.stream().mapToInt(i->i).toArray();
    }
}