import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        int[] answer = new int[n];
        Map<String, Integer> idxMap = new HashMap<>();
        for(int i=0; i<n; i++) idxMap.put(enroll[i], i);
        
        int[] parent = new int[n];
        for(int i=0; i<n; i++) parent[i] = referral[i].equals("-") ? -1 : idxMap.get(referral[i]);
        
        for(int i=0; i<seller.length; i++) {
            int profit = amount[i]*100;
            int cur = idxMap.get(seller[i]);
            while(cur!=-1 && profit>0) {
                int commission = profit / 10;
                answer[cur] += profit - commission;
                cur = parent[cur];
                profit = commission;
            }
        }
        
        return answer;
    }
}