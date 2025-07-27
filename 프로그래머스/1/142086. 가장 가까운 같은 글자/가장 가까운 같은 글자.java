import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> idxMap = new HashMap<>();
        
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            answer[i] = i - idxMap.getOrDefault(s.charAt(i), i+1);
            idxMap.put(s.charAt(i), i);
        }
        
        return answer;
    }
}