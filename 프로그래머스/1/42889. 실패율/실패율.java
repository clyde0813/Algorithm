import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double total = stages.length;
        
        int[] challenger = new int[N+2];
        IntStream.of(stages).forEach(stage -> challenger[stage]++);
        
        Map<Integer, Double> map = new HashMap<>();
        for(int i = 1; i<N+1; i++){
            if(challenger[i] == 0){
                map.put(i, 0.);
            } else {
                map.put(i, challenger[i]/total);
                total -= challenger[i];
            }
        }
        // Stable 정렬 + HashMap 인덱스 활용 
        return map.entrySet().stream().sorted((o1, o2) -> 
                                            Double.compare(o2.getValue(), o1.getValue())).mapToInt(HashMap.Entry::getKey).toArray();
    }
}