import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Deque<Integer> basket = new ArrayDeque<>();
        Deque<Integer>[] cols= new ArrayDeque[n + 1];
        
        for(int i = 1; i<=n; i++) cols[i] = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++){
            for(int j = n - 1; j>=0; j--){
                if(board[j][i] != 0) cols[i + 1].addLast(board[j][i]);
            }
        }
        
        for(int move : moves){
            if(!cols[move].isEmpty()){
                int top = cols[move].pollLast();
                if(!basket.isEmpty() && basket.peekLast().equals(top)) {
                    basket.pollLast();
                    answer += 2;
                } else {
                    basket.addLast(top);
                }
            }
        }

        return answer;
    }
}