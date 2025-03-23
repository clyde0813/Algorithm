import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int rPc = (brown/2) + 2;
        int row = (rPc + (int) Math.sqrt(rPc*rPc - 4 * total)) / 2;
        int column = (rPc - (int) Math.sqrt(rPc*rPc - 4 * total)) / 2;
        return new int[]{row, column};
    }
}