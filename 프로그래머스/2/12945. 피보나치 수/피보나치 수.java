class Solution {
    public int solution(int n) {
        int prev = 0;
        int current = 1;
        while(n-1>0){
            int tmp = current + prev;
            prev = current;
            current = tmp % 1234567;
            n--;
        }
        return current;
    }
}