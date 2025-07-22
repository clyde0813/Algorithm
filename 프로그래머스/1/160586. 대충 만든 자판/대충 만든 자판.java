import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> keyMap = new HashMap<>();
        
        for(String key : keymap) {
            for(int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                if(keyMap.containsKey(c) && keyMap.get(c) <= i+1) continue;
                keyMap.put(c, i+1);
            }
        }
        
        int[] answer = new int[targets.length];
        for(int i=0; i<targets.length; i++) {
            String target = targets[i];
            int result = 0;
            for(int j=0; j<target.length(); j++) {
                char c = target.charAt(j);
                if(!keyMap.containsKey(c)) {
                    result = -1;
                    break;
                }
                result += keyMap.get(c);
            }
            answer[i] = result;
        }
        
        return answer;
    }
}