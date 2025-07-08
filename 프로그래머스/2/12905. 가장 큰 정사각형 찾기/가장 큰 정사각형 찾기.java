class Solution
{
    public int solution(int [][]board) {
        int n = board.length;
        int m = board[0].length;
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i!=0 && j!=0 && board[i][j]==1) {
                    int up = board[i-1][j];
                    int left = board[i][j-1];
                    int upleft = board[i-1][j-1];
                    
                    board[i][j] += Math.min(upleft, Math.min(up, left));
                }
                answer = Math.max(answer, board[i][j]);
            }
        }

        return answer * answer;
    }
}