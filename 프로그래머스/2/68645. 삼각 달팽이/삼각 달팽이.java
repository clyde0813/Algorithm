class Solution {
    public int[] solution(int n) {
        int size = n * (n+1) / 2;
        int[] answer = new int[size];
        
        int[][] dirs = {{1,0}, {0,1}, {-1,-1}};
        int dIdx = 0;
        int num = 1;
        int y = -1, x = 0;
        
        for(int step=n; step>0; step--) {
            for(int i=0; i<step; i++) {
                y += dirs[dIdx][0];
                x += dirs[dIdx][1];
                
                int idx = y * (y+1) / 2 + x;
                answer[idx] = num++;
            }
            dIdx = (dIdx+1) % 3;
        }
        
        return answer;
    }
}