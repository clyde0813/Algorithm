import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        list1 = getMultiset(str1);
        list2 = getMultiset(str2);

        Collections.sort(list1);
        Collections.sort(list2);

        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        List<String> list1Copy = list1.stream()
            .collect(Collectors.toCollection(ArrayList::new));
        List<String> list2Copy = list2.stream()
            .collect(Collectors.toCollection(ArrayList::new));
        
        intersection = getIntersection(list1Copy, list2Copy);
        union = getUnion(list1, list2);

        if(intersection.size() > 0 && union.size() == 0) return 0;
        if(intersection.size() == 0 && union.size() == 0) return 65536;
        
        return (int) (((double) intersection.size() / union.size()) * (double) 65536);
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

        for(String s : shorter) {
            if(longer.contains(s)) {
                result.add(s);
                longer.remove(s);
            }
        }
        
        return result;
    }
    
    private List<String> getUnion(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        List<String> longer = (list1.size() >= list2.size()) ? list1 : list2;
        List<String> shorter = (list1.size() < list2.size()) ? list1 : list2;
        
        for(String s : shorter) {
            if(longer.contains(s)) longer.remove(s);
            result.add(s);
        }

        for(String l : longer) result.add(l);

        return result;
    }
}