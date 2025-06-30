class Solution {
    public int solution(String number) {
        int value = 0;
        for(char n : number.toCharArray()) value += (int) n - '0';
        return value % 9;
    }
}