import java.util.*;

class Solution {
    public int[] solution(String s) {
        String S = s.substring(0, s.length()-2).replace("{", "");
        String[] arr = S.split("},");
        Arrays.sort(arr, (o1, o2) -> Integer.compare(o1.length(), o2.length()));
        
        Set<String> set = new HashSet<>();
        int[] answer = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            String[] temp = arr[i].split(",");
            for(String t : temp) {
                if(set.contains(t)) continue;
                set.add(t);
                answer[i] = Integer.valueOf(t);
            }
        }
        
        return answer;
    }
}