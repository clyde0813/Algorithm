import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int todayInt = dateToInt(today);
        Map<String, Integer> termMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(String term : terms) termMap.put(term.split(" ")[0], Integer.valueOf(term.split(" ")[1]));
        
        for(int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            String term = privacy.split(" ")[1];
            int dateInt = dateToInt(privacy.split(" ")[0]);
            if(dateInt + (termMap.get(term)*28) <= todayInt) answer.add(i+1);            
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    private int dateToInt(String date) {
        int[] arr = Arrays.stream(date.split("\\.")).mapToInt(Integer::parseInt).toArray();
        return ((arr[0]%2000) * 12 * 28) + (arr[1] * 28) + (arr[2]);
    }
}