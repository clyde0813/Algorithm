import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        for(int c : course){
            Map<String, Integer> hashmap = new HashMap<>();
            for(String order : orders){
                if(order.length() >= c){
                    char[] orderCharArray = order.toCharArray();
                    Arrays.sort(orderCharArray);
                    combination(orderCharArray, new StringBuilder(), 0, c, hashmap);
                }
            }
            // 그냥 간지용
            // 일반 루프(for)가 더 빠르다
            hashmap.values().stream()
                .filter(o -> o >= 2)
                .max(Comparator.comparingInt(o -> o))
                .ifPresent(maxOrder -> hashmap.entrySet().stream()
                           .filter(entry -> entry.getValue() == maxOrder)
                           .forEach(entry -> answer.add(entry.getKey()))
                );
            // 이게 더 빠름
            /**
            for(Map.Entry<String, Integer> entry : hashmap.entrySet()){
                if(entry.getValue()>=2){
                    maxOrder = entry.getValue() > maxOrder ? entry.getValue() : maxOrder;
                };
            }
            for(Map.Entry<String, Integer> entry : hashmap.entrySet()){
                if(entry.getValue() == maxOrder) answer.add(entry.getKey());
            }
            **/
        }
        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }
    
    private void combination(char[] arr, StringBuilder sb, int start, int length, Map<String, Integer> hashmap){
        if(sb.length() == length) {
            hashmap.put(sb.toString(), hashmap.getOrDefault(sb.toString(), 0)+1);
            return;
        }
        
        for(int i=start; i<arr.length; i++){
            sb.append(arr[i]);
            combination(arr, sb, i+1, length, hashmap);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}