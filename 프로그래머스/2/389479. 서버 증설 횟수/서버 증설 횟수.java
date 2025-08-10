import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        Map<Integer, Integer> serverMap = new HashMap<>();
        
        int answer = 0;
        int server = 0;
        for(int i=0; i<players.length; i++) {
            if(serverMap.containsKey(i)) {
                server -= serverMap.get(i);
                serverMap.remove(i);
            }
            
            int player = players[i];
            if(player > server * m) {
                int newServer = (int) Math.ceil((player - (server * m)) / m);
                server += newServer;
                answer += newServer;
                serverMap.put(i+k, newServer);
            }
        }
        
        return answer;
    }
}