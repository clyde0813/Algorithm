class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        
        int gcdA = getGCD(arrayA);
        int gcdB = getGCD(arrayB);
        
        int candidateA = getValidDivisor(gcdA, arrayB);
        int candidateB = getValidDivisor(gcdB, arrayA);
        
        return Math.max(candidateA, candidateB);
    }
    
    private int getGCD(int[] arr) {
        int g = arr[0];
        
        for(int i=1; i<arr.length; i++) {
            g = gcd(g, arr[i]);
        }
        
        return g;
    }
    
    private int gcd(int a, int b) {
        while(b!=0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        
        return a;
    }
    
    private int getValidDivisor(int num, int[] arr) {
        int max = 0;
        
        for(int i=1; i*i<=num; i++) {
            if(num%i==0) {
                if(isValid(i, arr)) max = Math.max(max, i);
                
                int pair = num/i;
                if(isValid(pair, arr)) max = Math.max(max, pair);
            }
        }
        
        return max;
    }
    
    private boolean isValid(int num, int[] arr) {
        for(int a : arr) if(a%num==0) return false;
        return true;
    }
}