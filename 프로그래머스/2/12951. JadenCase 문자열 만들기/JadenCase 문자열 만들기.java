import java.util.*;

class Solution {
    public String solution(String s) {
		return toJadenCase(s);
    }
    
    public static String toJadenCase(String s){
        StringBuilder sb = new StringBuilder();
        char[] ca = s.toCharArray();
        boolean isStart = true;
		
        for(char c : ca){
            sb.append(isStart ? Character.toUpperCase(c) : Character.toLowerCase(c));
            isStart = (c == ' ') ? true : false;
        }
        
        return sb.toString();
    }
}