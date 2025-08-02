class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dSum = 0;
        int pSum = 0;
        
        for(int i=n-1; i>=0; i--) {
            dSum += deliveries[i];
            pSum += pickups[i];
            
            while(dSum>0 || pSum>0) {
                dSum -= cap;
                pSum -= cap;
                answer += (i+1) * 2;
            }
        }
        
        return answer;
    }
}