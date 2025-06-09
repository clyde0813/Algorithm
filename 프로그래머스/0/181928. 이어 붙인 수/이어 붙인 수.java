import java.util.*;

class Solution {
    private static int[] num_list;
    private static int n;
    
    public int solution(int[] num_list) {
        this.num_list = num_list;
        this.n = num_list.length;

        return stringCalculate();
    }
    
    private static int intCaluate() {
        int value = 0;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        
        for(int num : num_list) {
            if(num%2==0) even.add(num);
            else odd.add(num);
        }
        
        int evenLength = even.size()-1;
        for(int e : even) {
            value += e * Math.pow(10, evenLength--);
        }
        
        int oddLength = odd.size()-1;
        for(int o : odd) {
            value += o * Math.pow(10, oddLength--);
        }
        
        return value;
    }
    
    private static int stringCalculate() {        
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        for(int num : num_list) {
            if(num%2==0) even.append(num);
            else odd.append(num);
        }
        
        return Integer.valueOf(even.toString()) + Integer.valueOf(odd.toString());
    }
}