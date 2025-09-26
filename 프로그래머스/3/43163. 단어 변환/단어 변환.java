import java.util.*;

class Solution {
    private Map<String, List<String>> map = new HashMap<>();
    private Set<String> visited = new HashSet<>();
    private int length;
    
    public int solution(String begin, String target, String[] words) {
        this.length = begin.length();
        createMap(words);
        int answer = bfs(begin, target);
        
        return answer;
    }
    
    private void createMap(String[] words) {
        for(String word : words) {
            for(int i=0; i<length; i++) {
                StringBuilder key = new StringBuilder();
                key.append(word.substring(0, i)).append("*").append(word.substring(i+1));
                map.computeIfAbsent(key.toString(), o -> new ArrayList<>()).add(word);
            }
        }
    }
    
    private int bfs(String begin, String target) {
        Deque<Node> deque = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        deque.offer(new Node(begin, 0));
        
        while(!deque.isEmpty()) {
            Node current = deque.poll();
            String word = current.word;
            int depth = current.depth;
            
            if(word.equals(target)) return depth;
            
            for(int i=0; i<length; i++) {
                StringBuilder key = new StringBuilder();
                key.append(word.substring(0, i)).append("*").append(word.substring(i+1));
                                    
                if(!map.containsKey(key.toString())) continue;
                
                for(String w : map.get(key.toString())) {
                    if(visited.contains(w)) continue;
                    
                    visited.add(w);
                    deque.offer(new Node(w, depth + 1));
                }
            }
        }
        
        return 0;
    }
    
    static class Node {
        private String word;
        private int depth;
        
        public Node(String word, int depth) {
            this.word = word;
            this.depth = depth;
        }
    }
}