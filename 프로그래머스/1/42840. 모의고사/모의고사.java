import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] first = new int[]{1,2,3,4,5};
        int[] second = new int[]{2,1,2,3,2,4,2,5};
        int[] third = new int[]{3,3,1,1,2,2,4,4,5,5};
        int fl = first.length;
        int sl = second.length;
        int tl = third.length;
        int[] count = new int[3];
        
        for(int i = 0; i<answers.length; i++){
            int answer = answers[i];
            if(answer == first[i%fl]) count[0]++;
            if(answer == second[i%sl]) count[1]++;
            if(answer == third[i%tl]) count[2]++;
        }
        
        int max = Arrays.stream(count).max().getAsInt();
        
        return IntStream.range(0, 3).filter(i -> count[i] == max).map(i -> i+1).toArray();
    }
}