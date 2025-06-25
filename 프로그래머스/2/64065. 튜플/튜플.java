import java.util.*;

class Solution {
    public int[] solution(String s) {
        String S = s.substring(0, s.length()-2).replace("{", "");
        String[] sArray = S.split("},");
        Arrays.sort(sArray, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        Set<String> set = new HashSet<>();
        int[] answer = new int[sArray.length];
        
        for(int i=0; i<sArray.length; i++) {
            String[] temp = sArray[i].split(",");
            for(String t : temp) {
                if(set.contains(t)) continue;
                set.add(t);
                answer[i] = Integer.valueOf(t);
            }
        }
        
        return answer;
    }
}