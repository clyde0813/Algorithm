class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
    
    private int dfs(int idx, int value, int[] numbers, int target) {
        if(idx==numbers.length) {
            if(value == target) return 1; 
            return 0;
        }
        return dfs(idx+1, value+numbers[idx], numbers, target) + dfs(idx+1, value-numbers[idx], numbers, target);
    }
}