import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
        list.sort((s1, s2) -> 
                  (Integer.valueOf(s2+s1).compareTo(Integer.valueOf(s1+s2))));
        
        StringBuilder sb = new StringBuilder();
        for(String s : list) sb.append(s);
        
        return (sb.toString().charAt(0)=='0') ? "0" : sb.toString();
    }
}