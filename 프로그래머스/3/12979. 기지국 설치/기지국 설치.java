class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int location = 0;
        int idx = 0;
        
        while(location<n) {
            if(idx<stations.length && stations[idx]-w-1<=location) {
               location = stations[idx++] + w;
            } 
            else {
                location += 2*w+1;
                answer++;
            }
        }

        return answer;
    }
}