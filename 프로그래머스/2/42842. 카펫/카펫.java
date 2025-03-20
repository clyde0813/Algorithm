import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i=1; i <= yellow; i++){
            if(yellow % i == 0){
                if(brown == i*2+4 + yellow/i*2){
                    return new int[]{Math.max(i + 2, yellow/i + 2), Math.min(i+2, yellow/i + 2)};
                }
            }
        }
        return null;
    }
}