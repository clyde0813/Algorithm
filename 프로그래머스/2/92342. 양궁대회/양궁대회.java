import java.util.*;

class Solution {
    private static int max = 0;
    private static int[] answer;
    private static int[] apeach;
    
    public int[] solution(int n, int[] info) {
        this.apeach = info;
        this.answer = new int[11];
        
        backtrack(n, 0, new int[11]);
       	
        return (max==0) ? new int[]{-1} : answer;
    }
    
    private static int getScore(int[] ryan) {
        int score = 0;
        for(int i=0; i<11; i++) if(ryan[i]+apeach[i]!=0) score += (ryan[i]>apeach[i]) ? (10-i) : -(10-i);
        return score;
    }
    
    private static void check(int[] ryan) {
        int score = getScore(ryan);
        if(score<=0) return;
        
        if(score>max) updateAnswerAndMax(score, ryan);
        else if(score==max) {
            for(int i=10; i>=0; i--) {
                if(ryan[i]!=answer[i]) {
                    if(ryan[i]>answer[i]) updateAnswerAndMax(score, ryan);
                    else return;
                }
            }
        }
        return;
    }
    
    private static void updateAnswerAndMax(int score, int[] ryan) {
        answer = ryan.clone();
        max = score;
    }
    
    private static void backtrack(int n, int idx, int[] ryan) {
        if(n==0) {
            check(ryan);
            return;
        }
        
        for(int i=idx; i<11; i++) {
            int need = apeach[i] + 1;
            if(i==10) need = n;
            if(n<need) continue;
            ryan[i] = need;
            backtrack(n-need, i+1, ryan);
            ryan[i] = 0;
        }        
    } 
}