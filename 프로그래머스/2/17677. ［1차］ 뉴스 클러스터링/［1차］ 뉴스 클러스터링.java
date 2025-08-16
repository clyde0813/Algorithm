import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = getMultiset(str1);
        List<String> list2 = getMultiset(str2);

        int multisetSize = list1.size() + list2.size();

        List<String> intersection = new ArrayList<>();        
        intersection = getIntersection(list1, list2);
        
        int unionSize = multisetSize - intersection.size();

        if(intersection.size() == 0 && unionSize == 0) return 65536;
        if(unionSize == 0) return 0;
        return (int) (((double) intersection.size() / unionSize) * 65536);
    }
    
    private List<String> getMultiset(String str) {
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<str.length()-1; i++) {
            String temp = str.substring(i, i+2);
            if(!Character.isAlphabetic(temp.charAt(0)) 
               || !Character.isAlphabetic(temp.charAt(1))) continue;
            
            result.add(temp.toLowerCase());
        }

        return result;
    }
    
    private List<String> getIntersection(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        List<String> longer = (list1.size() >= list2.size()) ? list1 : list2;
        List<String> shorter = (list1.size() < list2.size()) ? list1 : list2;

        for(String s : shorter) if(longer.remove(s)) result.add(s);
        
        return result;
    }
}