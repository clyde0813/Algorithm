import java.util.*;

class Solution {
    private int[] info;
    private List<Integer>[] tree;
    private int answer;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        this.info = info;    
        this.tree = new ArrayList[n];
        
        for(int i=0; i<n; i++) tree[i] = new ArrayList<>();
        
        for(int[] edge : edges) tree[edge[0]].add(edge[1]);
        
        List<Integer> visitable = new ArrayList<>();
        visitable.add(0);
        
        dfs(0, 0, visitable);
        
        return answer;
    }
    
    private void dfs(int sheep, int wolf, List<Integer> visitable) {
        answer = Math.max(answer, sheep);
        
        for(int i=0; i<visitable.size(); i++) {
            int edge = visitable.get(i);
            int ns = sheep + (info[edge] == 0 ? 1 : 0);
            int nw = wolf + (info[edge] == 1 ? 1 : 0);
            
            if(ns<=nw) continue;
            
            List<Integer> newVisitable = new ArrayList<>(visitable);
            newVisitable.remove(i);
            
            for(int child : tree[edge]) newVisitable.add(child);
            
            dfs(ns, nw, newVisitable);
        }
        
        return;
    } 
}