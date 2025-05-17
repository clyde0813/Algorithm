import java.util.*;

class Solution {
    private int answer = 0;
    private Map<Integer, List<Integer>> edgeMap = new HashMap<>();
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
        
        for(Integer child : children){
            List<Integer> copy = new ArrayList<>(children);
            if(edgeMap.get(child) != null){
                copy.addAll(edgeMap.get(child));
            } 
            copy.remove(child);
            if(info[child]==0) dfs(sheep+1, wolf, copy, info);
            else dfs(sheep, wolf+1, copy, info);
        }
    }
}