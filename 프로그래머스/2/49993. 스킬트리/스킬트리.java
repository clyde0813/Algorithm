import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s : skill_trees) {
            int idx = 0;
            for(int i=0; i<s.length(); i++) {   
                int c = skill.indexOf(s.charAt(i));
                if(c != -1 && c != idx) break;
                if(c == idx) idx++;
                if(i == s.length()-1) answer++;
            }
        }
        return answer;
    }
}