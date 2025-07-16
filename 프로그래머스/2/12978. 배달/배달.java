import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int[] r : road) {
            graph[r[0]].add(new int[]{r[1], r[2]});
            graph[r[1]].add(new int[]{r[0], r[2]});
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];
            if (d > dist[node]) continue;

            for (int[] next : graph[node]) {
                int to = next[0], cost = next[1];
                if (dist[to] > dist[node] + cost) {
                    dist[to] = dist[node] + cost;
                    pq.offer(new int[]{to, dist[to]});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) if (dist[i] <= K) answer++;
        return answer;
    }
}
