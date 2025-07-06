class Solution {
    public int solution(int n) {
        int past = 1;
        int current = 2;
        
        for(int i=2; i<n; i++) {
            int tmp = current;
            current = (past + current) % 1000000007;
            past = tmp;
        }
        
        return current;
    }
}