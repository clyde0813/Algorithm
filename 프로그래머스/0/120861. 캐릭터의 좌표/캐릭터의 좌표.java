class Solution {
    private static int n, m;
    
    public int[] solution(String[] keyinput, int[] board) {
        this.n = board[1]/2;
        this.m = board[0]/2;
        
        int[] answer = new int[2];
        
        for(String key : keyinput) {
            if(key.equals("up")) {
                if(!isValid(answer[1]+1, answer[0])) continue;
                answer[1]++;
            }
            else if(key.equals("down")) {
                if(!isValid(answer[1]-1, answer[0])) continue;
                answer[1]--;
            }
            else if(key.equals("left")) {
                if(!isValid(answer[1], answer[0]-1)) continue;
                answer[0]--;
            }
            else {
                if(!isValid(answer[1], answer[0]+1)) continue;
                answer[0]++;
            }
        }
        
        return answer;
    }
    
    private static boolean isValid(int y, int x) {
        return n>=y && y>=-n && m>=x && x>=-m;
    }
}