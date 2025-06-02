import java.util.*;

class Solution {
    public int solution(int a, int b) {
        return Math.max(convert(a, b), 2*a*b);
    }
    
    private int convert(int a, int b){
        return (a * (int)Math.pow(10, (int)(Math.log10(b)+1))) + b;
    }
}