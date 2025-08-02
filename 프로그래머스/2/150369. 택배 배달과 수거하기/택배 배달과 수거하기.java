class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dRemain = 0;
        int pRemain = 0;
        
        for(int i=n-1; i>=0; i--) {
            deliveries[i] -= dRemain;
            pickups[i] -= pRemain;
            if(deliveries[i]==0 && pickups[i]==0) {
                dRemain = 0;
                pRemain = 0;
                continue;
            }
            int max = Math.max(deliveries[i], pickups[i]);
            
            int count = (max+(cap-1)) / cap;
            answer += count * (i+1) * 2;
            dRemain = (cap*count) - deliveries[i];
            pRemain = (cap*count) - pickups[i];
        }
        
        return answer;
    }
}