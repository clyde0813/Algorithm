import java.util.*;

class Solution {
    private Map<String, List<String>> map = new HashMap<>();
    private Set<String> visited = new HashSet<>();
    private int answer = Integer.MAX_VALUE;
    private int length;
    
    public int solution(String begin, String target, String[] words) {
        this.length = begin.length();
        
        createMap(words);
        dfs(begin, target, 0);
        
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
    
    private void createMap(String[] words) {
        
        for(String word : words) {
            for(int i=0; i<length; i++) {
                StringBuilder key = new StringBuilder();
                for(int j=0; j<length; j++) {
                    if(j==i) continue;
                    
                    key.append(j).append(word.charAt(j));
                }
                map.computeIfAbsent(key.toString(), o -> new ArrayList<>()).add(word);
            }
        }
    }
    
    private void dfs(String begin, String target, int count) {
        if(begin.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        
        for(int i=0; i<length; i++) {
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<length; j++) {
                if(j==i) continue;
                
                sb.append(j).append(begin.charAt(j));
            }
            
            if(!map.containsKey(sb.toString())) continue;
            
            for(String word : map.get(sb.toString())) {
                if(visited.contains(word)) continue;
                
                visited.add(word);
                dfs(word, target, count+1);
                visited.remove(word);
            }
        }
        
        return;
    }
}