import java.util.*;

class Solution {
    List<Integer>[] tree;
    int maxSheep = 0;
    int n;
    int[] info;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        n = info.length;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        int initMask = 0;
        for (int child : tree[0]) {
            initMask |= (1 << child);
        }

        dfs(1, 0, initMask);
        return maxSheep;
    }

    void dfs(int sheep, int wolf, int visitMask) {
        maxSheep = Math.max(maxSheep, sheep);

        for (int next = 0; next < n; next++) {
            if ((visitMask & (1 << next)) == 0) continue;

            int type = info[next];
            int newSheep = sheep + (type == 0 ? 1 : 0);
            int newWolf = wolf + (type == 1 ? 1 : 0);

            if (newWolf >= newSheep) continue;

            int nextMask = (visitMask & ~(1 << next));
            for (int child : tree[next]) {
                nextMask |= (1 << child);
            }

            dfs(newSheep, newWolf, nextMask);
        }
    }
}
