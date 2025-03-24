import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        List<Integer> tCount = new ArrayList<>();
        
        int count = 1;
        for(int i = 1; i < tangerine.length; i++){
            if(tangerine[i-1] == tangerine[i]){
                count++;
            } else {
                tCount.add(count);
                count = 1;
            }
        }
        tCount.add(count);
        
        Collections.sort(tCount, Collections.reverseOrder());
        
        int answer = 0;
        for(Integer c : tCount){
            k -= c;
            answer++;
            if(k <= 0){
                return answer;
            }
        }
        
        return answer;
    }
}