import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> wantHM = new HashMap<>();
        int dLength = discount.length;
        int dIndex = 0;
        int answer = 0;
        
        for(int i = 0; i<want.length; i++){
            wantHM.put(want[i], number[i]);
        }
        
        
        while(dIndex + 10 < dLength + 1){
            HashMap<String, Integer> hashmap = new HashMap<>();
            for(int i = dIndex; i<dIndex+10; i++){
                hashmap.put(discount[i], hashmap.getOrDefault(discount[i], 0) + 1);
            }
            if(wantHM.equals(hashmap)) answer++;
            dIndex++;
        }
        
        return answer;
    }
}