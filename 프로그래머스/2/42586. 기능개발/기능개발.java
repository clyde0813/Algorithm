import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int pLength = progresses.length;
        if(pLength == 0) return new int[]{};
        
        int[] days = new int[pLength];
        for(int i = 0; i<pLength; i++){
            days[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        
        int count = 1;
        int base = days[0];
        
        for(int i = 1; i<pLength; i++){
            if(days[i] <= base) count++;
            else {
                answer.add(count);
                count = 1;
                base = days[i];
            }
        }
        answer.add(count);
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}