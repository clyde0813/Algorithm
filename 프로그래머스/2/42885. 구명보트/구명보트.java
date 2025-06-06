import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int left = 0, right = people.length - 1;
        int answer = 0;
        Arrays.sort(people);
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}