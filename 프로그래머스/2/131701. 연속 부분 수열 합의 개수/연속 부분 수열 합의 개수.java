import java.util.*;

class Solution {    
    public int solution(int[] elements) {
        Set<Integer> answer = new HashSet<>();
        int[] ELEMENTS = new int[elements.length * 2];
        for(int i=0; i<elements.length; i++) {
            ELEMENTS[i] = elements[i];
            ELEMENTS[elements.length+i] = elements[i];
        }
        
        for(int i=1; i<=elements.length; i++) {
            for(int j=0; j<elements.length; j++) {
                int sum = 0;
                for(int p=0; p<i; p++) {
                    sum += ELEMENTS[j+p];
                }
                answer.add(sum);
            }
        }
        
        return answer.size();
    }
}