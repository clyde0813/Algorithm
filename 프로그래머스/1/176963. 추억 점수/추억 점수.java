import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<name.length; i++) map.put(name[i], yearning[i]);
        
        int[] answer = new int[photo.length];
        for(int i=0; i<photo.length; i++) {
            String[] p = photo[i];
            int result = 0;
            for(String n : p) result += map.getOrDefault(n, 0);
            answer[i] = result;
        }
        
        return answer;
    }
}