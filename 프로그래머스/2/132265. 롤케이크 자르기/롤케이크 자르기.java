import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Set<Integer> cntSet = new HashSet<>();
        int[] arr1 = new int[topping.length];
        int[] arr2 = new int[topping.length];
        
        for(int i=0; i<topping.length; i++) {
            cntSet.add(topping[i]);
            arr1[i] = cntSet.size();
        }
        
        cntSet.clear();
        
        for(int i=topping.length-1; i>=0; i--) {
            cntSet.add(topping[i]);
            arr2[i] = cntSet.size();
        }
        
        int answer = 0;
        for(int i=0; i<topping.length-2; i++) {
            if(arr1[i]==arr2[i+1]) answer++;
        }
        
        return answer;
    }
}