import java.util.*;

class Solution {
    private char[] charNumbers;
    private Set<Integer> answer = new HashSet<>();
    
    public int solution(String numbers) {
        this.charNumbers = numbers.toCharArray();
        
        int n = numbers.length();
        boolean[] visited = new boolean[n];
        
        dfs(new StringBuilder(), visited);

        return answer.size();
    }
    
    private void dfs(StringBuilder sb, boolean[] visited) {
        if(sb.length() > 0) {
            int value = Integer.parseInt(sb.toString());
            if(!answer.contains(value) && isPrime(value)) answer.add(value);
        }
        
        for(int i=0; i<charNumbers.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            sb.append(charNumbers[i]);
            dfs(sb, visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i] = false;
        }
    }
    
        private boolean isPrime(int number) {
        if(number == 0 || number == 1) return false;
        
        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        
        return true;
    }
}

/*
완전 탐색 문제 인듯 하다

25.09.30
에라토스테네스의 체 적용
이전 Time: 7.79 ms, Memory: 76.4 MB
적용 Time: 78.07 ms, Memory: 87 MB
에라토스테네스의 체를 사용하기에는 입력크기가 작다.
이 문제에서는 소수 판별을 매번 하는게 에라토스테네스의 체를 활용하는것 보다 오버헤드가 더 적다.
*/