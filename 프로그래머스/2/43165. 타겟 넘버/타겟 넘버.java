class Solution {
    private int[] numbers;
    private int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        return dfs(0, 0);
    }
    
    private int dfs(int idx, int value) {
        if(idx==numbers.length) {
            if(value == target) return 1; 
            return 0;
        }
        
        return dfs(idx+1, value+numbers[idx]) + dfs(idx+1, value-numbers[idx]);
    }
}