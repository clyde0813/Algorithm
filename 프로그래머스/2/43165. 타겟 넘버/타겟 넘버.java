class Solution {
    private int answer;
    private int[] NUMBERS;
    private int TARGET;
    
    public int solution(int[] numbers, int target) {
        this.NUMBERS = numbers;
        this.TARGET = target;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private void dfs(int idx, int value) {
        if(idx==NUMBERS.length) {
            if(value == TARGET) answer++; 
            return;
        }

        dfs(idx+1, value+NUMBERS[idx]);
        dfs(idx+1, value-NUMBERS[idx]);
        return;
    }
}