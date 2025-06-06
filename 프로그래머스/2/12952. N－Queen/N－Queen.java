class Solution {
    private static int answer;
    private static int n;
    private static boolean[] width;
    private static boolean[] diagonalRight;
    private static boolean[] diagonalLeft;
    
    public int solution(int n) {
        this.n = n;
        this.width = new boolean[n];
        this.diagonalRight = new boolean[n*2-1];
        this.diagonalLeft = new boolean[n*2-1];
        
        dfs(0);
        
        return answer;
    }
    
    private static void dfs(int y) {
        if(y==n) { 
            answer++;
            return;
        }
        
        for(int x=0; x<n; x++) {
            if(!isAvailable(x, y)) continue;
            
            setStatus(x, y, true);
            dfs(y+1);
            setStatus(x, y, false);
        }
        
        return;
    }
    
    private static boolean isAvailable(int x, int y) {
        return !(width[x] || diagonalRight[x-y+n-1] || diagonalLeft[x+y]);
    }
    
    private static void setStatus(int x, int y, boolean status) {
        width[x] = diagonalRight[x-y+n-1] = diagonalLeft[x+y] = status;
        return;
    }
}