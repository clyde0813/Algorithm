import java.util.*;

class Solution { 
    private Map<Integer, Integer> countMap = new HashMap<>();
    private long answer = 0;
    
    public long solution(int[] weights) {
        Arrays.sort(weights);
        
        for(int weight : weights) {
            check(weight);
            countMap.put(weight, countMap.getOrDefault(weight, 0)+1);
        }
                
        return answer;
    }
    
    private void check(int weight) {
        answer += countMap.getOrDefault(weight, 0);
        
        if(weight%2==0) answer += countMap.getOrDefault(weight/2, 0);
        
        if((2*weight)%3==0) answer += countMap.getOrDefault(2*weight/3, 0);
        
        if((3*weight)%4==0) answer += countMap.getOrDefault(3*weight/4, 0);
    }
}