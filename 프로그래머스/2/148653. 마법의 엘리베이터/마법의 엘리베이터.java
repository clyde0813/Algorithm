import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey > 0) {       
            int value = storey%10;
            storey /= 10;
            
            if(value > 5 || (storey%10 >= 5 && value == 5)) {
                answer += 10-value;
                storey += 1;
            }
            else answer += value;
        }
        
        return answer;
    }
}

/*
2554

15555
20000 - 2 
16000 - 4
15600 - 4
15560 - 4
15555 - 5

3
4 4 6

3000 - 3
2600 - 4
2560 - 4
2554 - 6 

119
100 - 1
120 - 2
119 - 1

5
4
5
2
*/