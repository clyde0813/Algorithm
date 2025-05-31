import java.util.*;

class Solution {
    public int solution(int a, int b) {
        return Math.max(combine(a,b), combine(b,a));
    }
    
    private int combine(int a, int b){
        StringBuilder sb = new StringBuilder();
        return Integer.parseInt(sb.append(a).append(b).toString());
    }
}