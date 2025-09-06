class Solution {
    private int[][] arr;
    private int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        
        dfs(0, 0, arr.length);
        
        return answer;
    }
    
    private void dfs(int y, int x, int n) {
        int pivot = arr[y][x];
        boolean status = true;
        
        Loop1 : for(int i=y; i<y+n; i++) {
            for(int j=x; j<x+n; j++) {
                if(pivot != arr[i][j]) {
                    status = false;
                    break Loop1;
                }
            }
        }
        
        if(status) {
            answer[pivot]++;
            return;
        }
        
        int half = n/2;
        dfs(y, x, half);
        dfs(y+half, x, half);
        dfs(y, x+half, half);
        dfs(y+half, x+half, half);
    }
}