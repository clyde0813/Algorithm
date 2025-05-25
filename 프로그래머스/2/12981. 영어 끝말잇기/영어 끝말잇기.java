import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        
        for(int i=0; i<words.length; i++){
            String word = words[i];
            if(i>0 && word.charAt(0)!=words[i-1].charAt(words[i-1].length()-1) || !wordSet.add(word)){
                System.out.println(i);
                return new int[]{(i%n+1), (i/n+1)};
            }
        }

        return new int[]{0,0};
    }
}