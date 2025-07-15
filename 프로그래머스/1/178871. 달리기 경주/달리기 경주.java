import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        Map<String, Integer> nameRank = new HashMap<>();
        Map<Integer, String> rankName = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            nameRank.put(players[i], i);
            rankName.put(i, players[i]);
        }
        
        for(String call : callings) {
            int rank = nameRank.get(call);
            String rival = rankName.get(rank-1);
            nameRank.put(call, rank-1);
            rankName.put(rank-1, call);
            nameRank.put(rival, rank);
            rankName.put(rank, rival);
        }
        
        String[] answer = new String[n];
        for(int i=0; i<n; i++) answer[i] = rankName.get(i);
        
        return answer;
    }
}