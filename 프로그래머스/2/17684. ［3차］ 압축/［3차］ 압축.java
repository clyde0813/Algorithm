import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        int idx = 0;
        while(idx<msg.length()) {
            if(idx==msg.length()-1) {
                answer.add(convertToInt(msg.charAt(idx)));
                break;
            }
            
            StringBuilder key = new StringBuilder();
            key.append(msg.charAt(idx));
            int value = convertToInt(msg.charAt(idx));
            
            for(int i=idx+1; i<msg.length(); i++) {
                key.append(msg.charAt(i));
                if(dict.containsKey(key.toString())) {
                    value = dict.get(key.toString());
                    idx = i;
                    continue;
                }
                dict.put(key.toString(), 27 + dict.size());
                break;
            }
            answer.add(value);
            idx++;
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private int convertToInt(char c) {
        return c - 'A' + 1;
    }
}