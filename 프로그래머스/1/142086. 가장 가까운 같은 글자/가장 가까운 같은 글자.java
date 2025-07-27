import java.util.*;

class Solution {
    public int[] solution(String s) {
        char[] charArray = s.toCharArray();
        Map<Character, Integer> idxMap = new HashMap<>();
        
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
            char c = charArray[i];
            if(idxMap.containsKey(c)) {
                answer[i] = i-idxMap.get(c);
                idxMap.put(c, i);
                continue;
            }
            answer[i] = -1;
            idxMap.put(c, i);            
        }
        
        return answer;
    }
}