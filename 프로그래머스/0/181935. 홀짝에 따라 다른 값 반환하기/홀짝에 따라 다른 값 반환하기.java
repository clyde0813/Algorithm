class Solution {
    public int solution(int n) {
        return oddEven(n);
    }
    
    private int oddEven(int n){
        if(n%2==0) return even(n);
        else return odd(n);
    }
    
    private int even(int n){
        int value = 0;
        for(int i=2; i<=n; i+=2) value += i*i;
        return value;
    }
    
    private int odd(int n){
        int value = 0;
        for(int i=1; i<=n; i+=2) value += i;
        return value;
    }
}