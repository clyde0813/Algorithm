import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        Map<Integer, Integer> map = new HashMap<>();
        for(char x : X.toCharArray()) {
            int xi = x-'0';
            map.put(xi, map.getOrDefault(xi, 0)+1);
        }
        
        List<Integer> match = new ArrayList<>();
        for(char y : Y.toCharArray()) {
            int yi = y-'0';
            if(map.containsKey(yi)) {
                match.add(yi);
                if(map.get(yi) == 1) map.remove(yi);
                else map.put(yi, map.get(yi)-1);
            }
        }
        if(match.isEmpty()) return "-1"; 
        
        Collections.sort(match, (m1, m2) -> {
            return (Integer.valueOf(String.valueOf(m2)+String.valueOf(m1))
                    .compareTo(Integer.valueOf(String.valueOf(m1)+String.valueOf(m2))));
        });
        
        if(match.get(0)==0) return "0";
        StringBuilder sb = new StringBuilder();
        for(int m : match) sb.append(m);
        return sb.toString();
    }
}