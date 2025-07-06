import java.util.*;

public class Solution {
    private List<Integer>[] adj;    // 트리 인접 리스트
    private int answer = 0;
    private int[] info;             // 노드별 (0:양, 1:늑대)

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
        // 시작점(0번 노드)을 후보 목록에 추가
        List<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(next, 0, 0);
        return answer;
    }

    private void dfs(List<Integer> nextList, int sheep, int wolf) {
        answer = Math.max(answer, sheep);

        // 후보 노드 중 하나씩 선택
        for (int i = 0; i < nextList.size(); i++) {
            int node = nextList.get(i);
            int ns = sheep + (info[node] == 0 ? 1 : 0);
            int nw = wolf  + (info[node] == 1 ? 1 : 0);
            // 늑대가 양 이상이면 불가능 경로
            if (nw >= ns) continue;

            // 상태 복사: 다음 후보 목록
            List<Integer> nxt = new ArrayList<>(nextList);
            nxt.remove(i);            // 지금 선택한 노드 제거
            // 선택 노드의 자식들 후보에 추가
            for (int child : adj[node]) {
                nxt.add(child);
            }

            dfs(nxt, ns, nw);
            // 백트래킹: nxt는 지역변수, 원본 nextList는 변경되지 않음
        }
    }
}
