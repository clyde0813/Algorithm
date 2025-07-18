class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int pivot = 0;
        
        for(int sec : section) {
            if(pivot>sec) continue;
            pivot = sec + m;
            answer++;
        }
        
        return answer;
    }
}