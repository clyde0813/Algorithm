import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        Map<String, Integer> idxMap = new HashMap<>();
        
        for(int i=0; i<n; i++) idxMap.put(players[i], i);
        
        for(String call : callings) {
            int cur = idxMap.get(call);
            
            String temp = players[cur];
            players[cur] = players[cur-1];
            players[cur-1] = temp;
            
            idxMap.put(players[cur], cur);
            idxMap.put(players[cur-1], cur-1);
        }
        
        return players;
    }
}