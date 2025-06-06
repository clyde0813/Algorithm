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
        
        dfs(0, 1);
        
        return answer;
    }
    
    private static void dfs(int y, int count){
        for(int x=0; x<n; x++){
            if(!isAvailable(x, y)) continue;
            if(count==n){
                answer++;
                return;
            }
            if(y+1<n){
                setStatus(x, y, true);
                dfs(y+1, count+1);
                setStatus(x, y, false);
            } else return;
        }
        return;
    }
    
    private static boolean isAvailable(int x, int y){
        return !(width[x] || diagonalRight[x-y+n-1] || diagonalLeft[x+y]);
    }
    
    private static void setStatus(int x, int y, boolean status){
        width[x] = status;
        diagonalRight[x-y+n-1] = status;
        diagonalLeft[x+y] = status;
        return;
    }
}