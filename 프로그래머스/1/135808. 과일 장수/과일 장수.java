import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> scoreList = Arrays.stream(score).boxed().collect(Collectors.toList());
        scoreList.sort(Collections.reverseOrder());
        for(int i=m-1; i<scoreList.size(); i+=m) answer += scoreList.get(i)*m;
        return answer;
    }
}