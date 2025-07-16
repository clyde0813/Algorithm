import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] r : road) {
            map.computeIfAbsent(r[0], o -> new ArrayList<>()).add(new int[]{r[0],r[1],r[2]});
            map.computeIfAbsent(r[1], o -> new ArrayList<>()).add(new int[]{r[1],r[0],r[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.addAll(map.get(1));
        
        int[] cost = new int[N];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0;
        
        int answer = 1;
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int parent = current[0]-1, child = current[1]-1, value = current[2];
            int currentCost = cost[parent] + value;
            
            if(currentCost<=K && currentCost<cost[child]) {
                if(map.containsKey(child+1)) pq.addAll(map.get(child+1));
                if(cost[child]==Integer.MAX_VALUE) answer++;
                cost[child] = currentCost;
            }
        }

        return answer;
    }
}