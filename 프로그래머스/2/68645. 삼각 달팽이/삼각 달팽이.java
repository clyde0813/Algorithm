class Solution {
    public int[] solution(int n) {
        int size = n * (n+1) / 2;
        int[] answer = new int[size];
        
        int[][] dirs = {{1,0}, {0,1}, {-1,-1}};
        int dIdx = 0;
        int num = 1;
        int x = -1, y = 0;
        
        for(int step=n; step>0; step--) {
            for(int i=0; i<step; i++) {
                x += dirs[dIdx][0];
                y += dirs[dIdx][1];
                
                int idx = x * (x+1) / 2 + y;
                answer[idx] = num++;
            }
            dIdx = (dIdx+1) % 3;
        }
        
        return answer;
    }
}