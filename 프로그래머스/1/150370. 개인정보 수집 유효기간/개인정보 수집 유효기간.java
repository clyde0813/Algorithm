import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayInt = dayToInt(today);
        Map<String, Integer> termMap = new HashMap<>();
        for(String term : terms) {
            termMap.put(term.split(" ")[0], Integer.valueOf(term.split(" ")[1])*28);
        }
        
        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            int day = dayToInt(privacy.split(" ")[0]) + termMap.get(privacy.split(" ")[1]);
            if(day<=todayInt) answer.add(i+1);
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private int dayToInt(String day) {
        int[] arr = Arrays.stream(day.split("\\.")).mapToInt(Integer::parseInt).toArray();
        return arr[0]*12*28 + arr[1]*28 + arr[2];
    }
}