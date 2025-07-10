import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) map.put(t, map.getOrDefault(t, 0)+1);
        
        int[] count = new int[map.size()];
        int idx = 0;
        for(int v : map.values()) count[idx++] = v;
        Arrays.sort(count);
        
        int answer = 0;
        for(int i=count.length-1; i>=0 && k>0; i--) {
            k -= count[i];
            answer++;
        }
        
        return answer;
    }
}