import java.util.Arrays;

class Solution {
    public String solution(String s) {
        int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(numbers).min().getAsInt() + " " + Arrays.stream(numbers).max().getAsInt();
    }
}