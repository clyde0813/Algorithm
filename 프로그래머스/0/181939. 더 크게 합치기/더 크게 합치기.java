import java.util.*;

class Solution {
    public int solution(int a, int b) {
        return Math.max(combine(a, b), combine(b, a));
    }
    
    private int combine(int a, int b){
        return (int) (a * Math.pow(10, (int) (Math.log10(b)+1)) + b);
    } 
}