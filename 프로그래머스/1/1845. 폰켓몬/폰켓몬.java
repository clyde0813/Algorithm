import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums){
            numSet.add(num);
        }        
        return Math.min((nums.length/2), numSet.size());
    }
}