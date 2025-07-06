import java.util.*;

class Solution {
    int solution(int[][] land) {
        for(int i=1; i<land.length; i++) {
            for(int j=0; j<4; j++) {
                int max = 0;
                for(int p=0; p<4; p++) if(p!=j) max = Math.max(max, land[i-1][p]);
                land[i][j] += max;
            }
        }

        return Arrays.stream(land[land.length-1]).max().getAsInt();
    }
}