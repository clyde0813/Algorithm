import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] leaderboard = new int[k];        
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++) {
            if(i<k || leaderboard[0] < score[i]) {
                leaderboard[0] = score[i];
                Arrays.sort(leaderboard);
            }
            answer[i] = (i<k) ? leaderboard[k-i-1] : leaderboard[0];
        }
        return answer;
    }
}