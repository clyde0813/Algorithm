import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<skill.length(); i++) map.put(skill.charAt(i), i);

        int answer = 0;
        for(String s : skill_trees) {
            int idx = 0;
            boolean flag = true;
            for(char c : s.toCharArray()) {                
                if(map.containsKey(c) && map.get(c) != idx) {
                    flag = false;
                    break;
                }
                if(map.containsKey(c) && map.get(c) == idx) {
                    idx++;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}