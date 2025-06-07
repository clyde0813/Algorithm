class Solution {
    private static int max = 0;
    private static int[] answer = new int[11];
    private static int[] info;
    
    
    public int[] solution(int n, int[] info) {
        this.info = info;
        backtrack(0, n, new int[11]);
        return (max==0) ? new int[]{-1} : answer;
    }
    
    private static void backtrack(int idx, int remain, int[] ryan) {
        if(remain == 0) {
            checkScore(ryan);
            return;
        }
        
        for(int i=idx; i<11; i++){
            int need = (i==10) ? remain : info[i]+1;
            if(need>remain) continue;

            ryan[i] = need;
            backtrack(i+1, remain-need, ryan);
            ryan[i] = 0;
        }
    }
    
    private static void checkScore(int[] ryan) {
        int score = getScore(ryan);
        
        if(max<score) {
            answer = ryan.clone();
            max = score;
            return;
        }
        else if(max==score) {
            for(int i=10; i>=0; i--) {
                if(answer[i]+ryan[i]==0) continue;
                else if(answer[i]>ryan[i]) return;
                else if(answer[i]<ryan[i]) {
                    answer = ryan.clone();
                    return;
                }
            }
        }
    }
    
    private static int getScore(int[] ryan) {
        int score = 0;
        for(int i=0; i<10; i++){
            if(info[i]+ryan[i]==0) continue;
            score += (info[i]>=ryan[i]) ? -(10-i) : (10-i);
        }
        return score;
    }
}