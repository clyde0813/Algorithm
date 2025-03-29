class Solution {
    public long solution(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int answer = 0;
        int a = 1;
        int b = 2;
        for(int i = 3; i <= n; i++){
            answer = (a + b) % 1234567;
            a = b;
            b = answer;
        }
        return answer;
    }
}