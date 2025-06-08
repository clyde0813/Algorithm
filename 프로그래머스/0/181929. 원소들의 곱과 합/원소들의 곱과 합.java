import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        return (Arrays.stream(num_list).reduce(1, (a,b) -> a*b)<Math.pow(Arrays.stream(num_list).sum(),2) ? 1: 0);
    }
}