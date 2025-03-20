import java.util.*;

class Solution
{
    public int solution(String s){
        return removePairsWithArray(s);
    }
    
    // ArrayDeque 사용
    public int removePairsWithDeque(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
    
    // 배열 사용
    public int removePairsWithArray(String s){
        char[] stack = new char[s.length()];
        int idx = -1;
        for(char c : s.toCharArray()){
            if(idx >= 0 && stack[idx] == c){
                idx--;
            } else {
                stack[++idx] = c;
            }
        }
        return idx == -1 ? 1 : 0;
    }
}