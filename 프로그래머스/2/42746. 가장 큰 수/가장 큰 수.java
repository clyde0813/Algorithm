import java.util.*;

class Solution {
    public String solution(int[] numbers) {        
        List<String> list = new ArrayList<>();
        for(int number : numbers) list.add(String.valueOf(number));
        
        list.sort((o1, o2) -> {
                int a = Integer.valueOf(o1 + o2);
     			int b = Integer.valueOf(o2 + o1);
               	return b - a;  
        });
                
        StringBuilder sb = new StringBuilder();
        for(String number : list) sb.append(number);
        
        return (sb.toString().charAt(0)=='0') ? "0" : sb.toString();
    }
}