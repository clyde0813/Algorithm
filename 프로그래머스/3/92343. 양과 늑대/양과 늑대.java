import java.util.*;

class Solution {
    private int[] info;
    private int[][] tree;
    private int answer;
    
    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        this.info = info;    
        this.tree = new int[n][2];
                
        for(int[] t : tree) Arrays.fill(t, -1);

        for(int[] edge : edges) {
            for(int i=0; i<2; i++) {
                if(tree[edge[0]][i]==-1) {
                    tree[edge[0]][i] = edge[1]; 
                    break;
                }
            }
        }
        
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
            
            for(int child : tree[edge]) if(child!=-1) newVisitable.add(child);
            
            dfs(ns, nw, newVisitable);
        }
        
        return;
    } 
}