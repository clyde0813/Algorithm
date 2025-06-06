import java.util.*;

class Solution {
    public int solution(int a, int b, int c) {
        int status = compare(a, b, c);
        if(status == 1) return (a+b+c) * (a*a + b*b + c*c) * (a*a*a + b*b*b + c*c*c);
        else if(status == 2) return (a+b+c) * (a*a + b*b + c*c);
        else return (a+b+c);
    }
    
    public static int compare(int a, int b, int c){
        Set<Integer> set = new HashSet<>(Arrays.asList(a,b,c));
        return set.size();
    }
}