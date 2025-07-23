import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        Set<Character> set = new HashSet();
        for(char c : skip.toCharArray()) set.add(c);
        
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            int idx = 0;
            while(idx<index) {
                arr[i] = (char) (arr[i]+1);
                if(arr[i] > 'z') arr[i] = 'a';
                if(set.contains(arr[i])) continue;
                idx++;
            }
        }
        
        return new String(arr);
    }
}