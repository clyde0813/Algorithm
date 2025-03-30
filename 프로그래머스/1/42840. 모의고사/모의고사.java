import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] count = IntStream.range(0,3)
            .map(i -> (int) IntStream.range(0, answers.length)
                .filter(j -> answers[j] == patterns[i][j % patterns[i].length])
                 .count()
                )
            .toArray();
        
        int max = Arrays.stream(count).max().getAsInt();
        
        return IntStream.range(0, 3).filter(i -> count[i] == max).map(i -> i + 1).toArray();
    }
}