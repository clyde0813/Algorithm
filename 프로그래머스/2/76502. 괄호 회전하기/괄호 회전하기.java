import java.util.*;

class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 0;
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i<s.length(); i++){
            if(checkBrace(sb.toString())){
                answer++;
            }
            char tmp = sb.charAt(0);
            sb.deleteCharAt(0).append(tmp);
        }
        return answer;
    }
    
    private boolean checkBrace(String s){        
        Deque<String> deque = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            String cs = String.valueOf(c);
            if(c == '(' || c == '{' || c == '[') deque.push(cs);
            else {
                if(deque.isEmpty()) return false;
                if(isMatching(deque.pop().charAt(0), cs.charAt(0))) continue;
                else return false;
            }
        }
        return (deque.isEmpty()) ? true : false;
    }
    
    private boolean isMatching(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}