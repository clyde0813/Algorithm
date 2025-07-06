import java.util.*;

public class Solution {
    private List<Integer>[] adj;    
    private int answer = 0;
    private int[] info;           

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        int n = info.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
        }

        List<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(next, 0, 0);
        return answer;
    }

    private void dfs(List<Integer> nextList, int sheep, int wolf) {
        answer = Math.max(answer, sheep);

        for (int i = 0; i < nextList.size(); i++) {
            int node = nextList.get(i);
            int ns = sheep + (info[node] == 0 ? 1 : 0);
            int nw = wolf  + (info[node] == 1 ? 1 : 0);

            if (nw >= ns) continue;

            List<Integer> nxt = new ArrayList<>(nextList);
            nxt.remove(i);         

            for (int child : adj[node]) {
                nxt.add(child);
            }

            dfs(nxt, ns, nw);
        }
    }
}
