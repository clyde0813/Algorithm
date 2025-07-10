import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int left = 0;
        int right = people.length-1;
        Arrays.sort(people);
        
        int answer = 0;
        while(left<right) {
            answer++;
            int total = people[left] + people[right];
            if(total>limit) right--;
            else {
                right--;
                left++;
            }
        }
        
        if(left==right) answer++;
        
        return answer;
    }
}