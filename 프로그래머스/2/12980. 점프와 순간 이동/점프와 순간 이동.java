import java.util.*;

public class Solution {
    public int solution(int n) {
        int count = 0;
        while(n!=0){
            n&=(n-1);
            count++;
        }
        return count;
    }
}