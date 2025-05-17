import java.util.*;
import java.util.stream.*;

class Solution {
    private int answer = 0;
    private Map<Integer, List<Integer>> edgeMap = new HashMap<>();
    private Set<String> visited = new HashSet<>();
    
    public int solution(int[] info, int[][] edges) {
        for(int[] edge : edges){
            edgeMap.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
        }
        dfs(1, 0, edgeMap.get(0), info);
        return answer;
    }
    
    private void dfs(int sheep, int wolf, List<Integer> children, int[] info){
        if(sheep <= wolf) return;
        answer = Math.max(sheep, answer);
        
        String key = sheep + "," + wolf + "," + children.stream().sorted().map(Object::toString).collect(Collectors.joining(","));
        if(visited.contains(key)) return;
        visited.add(key);
        
        for(Integer child : children){
            List<Integer> copy = new ArrayList<>(children);
            if(edgeMap.containsKey(child)){
                copy.addAll(edgeMap.get(child));
            } 
            copy.remove(child);
            if(info[child]==0) dfs(sheep+1, wolf, copy, info);
            else dfs(sheep, wolf+1, copy, info);
        }
    }
}