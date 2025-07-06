import java.util.*;

class Solution {
    private static int[] info;
    private static int[][] tree;
    private static int answer;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        int[][] tree = new int[info.length][2];
        for(int[] t : tree) Arrays.fill(t, -1);
        
        for(int[] edge : edges) {
            for(int i=0; i<2; i++) {
                if(tree[edge[0]][i]==-1) {
                    tree[edge[0]][i] = edge[1];
                    break;
                }
            }
        }
        
        this.tree = tree;
        backtrack(1, 0, tree[0]);
        
        return answer;
    }
    
    private static void backtrack(int sheep, int wolf, int[] visitable) {
        if(sheep<=wolf) return;
        
        int result = 0;
        
        for(int v : visitable) {
            if(v==-1) continue;
            
            int[] newVisitable = new int[(visitable.length-1)+2];
            int idx = 0;
            for(int nv : visitable) if(nv!=v) newVisitable[idx++] = nv;
            for(int child : tree[v]) newVisitable[idx++] = child;
                        
            if(info[v]==0) backtrack(sheep+1, wolf, newVisitable);
            else backtrack(sheep, wolf+1, newVisitable);
        }
        
        answer = Math.max(sheep, answer);
        
        return;
    }
}