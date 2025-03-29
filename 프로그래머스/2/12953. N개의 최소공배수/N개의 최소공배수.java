class Solution {
    public int gcd(int a, int b){
        return (b==0) ? a : gcd(b, a%b);
    }
    
    public int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
    
    public int solution(int[] arr) {
        int answer = arr[0];
        for(int i = 1; i<arr.length; i++){
            answer = lcm(answer, arr[i]);
        }
        return answer;
    }
}