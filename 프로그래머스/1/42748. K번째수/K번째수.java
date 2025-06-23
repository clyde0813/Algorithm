import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int copyLen = command[1] - command[0] + 1;
            int[] temp = new int[copyLen];
            System.arraycopy(array, command[0]-1, temp, 0, copyLen);
            Arrays.sort(temp);
            answer[i] = temp[command[2]-1];
        }
        
        return answer;
    }
}