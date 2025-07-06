import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> idxMap = new HashMap<>();
        Map<String, String> treeMap = new HashMap<>();
        for(int i=0; i<enroll.length; i++) {
            idxMap.put(enroll[i], i);
            if(!referral[i].equals("-")) treeMap.put(enroll[i], referral[i]);
        }
        
        for(int i=0; i<seller.length; i++) {
            int profit = amount[i]*100;
            String target = seller[i];
            while(target!=null && profit!=0 ) {
                answer[idxMap.get(target)] += profit - (int) (profit * 0.1);
                target = treeMap.get(target);
                profit = (int) (profit * 0.1);
            }
        }
        
        return answer;
    }
}