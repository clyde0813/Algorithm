import java.util.*;

class Solution {
    public int solution(int a, int b) {
        return Math.max(combineAndConvert(a,b), combineAndConvert(b,a));
    }
    
    private int combineAndConvert(int a, int b){
        return Integer.valueOf(String.valueOf(a) + String.valueOf(b));
    }
}