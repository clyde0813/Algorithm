import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Deque<Integer> trash = new ArrayDeque<>();
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for(int i=1; i<n+2; i++){
            up[i] = i-1;
            down[i] = i+1;
        }
        
        k++;

        for(String c : cmd){
            if(c.equals("C")) {
                trash.addFirst(k);
                down[up[k]] = down[k];
                up[down[k]] = up[k];
                k = n<down[k] ? up[k] : down[k];
            } else if(c.equals("Z")) {
                int idx = trash.pollFirst();
                down[up[idx]] = idx;
                up[down[idx]] = idx;
            } else {
                String direction = c.split(" ")[0];
                int move = Integer.valueOf(c.split(" ")[1]);
                for(int i=0; i<move; i++){
                    k = direction.equals("U") ? up[k] : down[k];
                }
            }
        }
        
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        for(int t : trash){
            answer[t-1] = 'X';
        }
        
        return new String(answer);
    }
}