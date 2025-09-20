import java.util.*;

class Solution {
    private char[] charNumbers;
    private boolean[] isPrime;
    private Set<Integer> answer = new HashSet<>();
    
    public int solution(String numbers) {
        this.charNumbers = numbers.toCharArray();
        
        int n = numbers.length();
        int max = (int) Math.pow(10, n) - 1;
        boolean[] visited = new boolean[n];
        
        primeNumberSieve(max);
        dfs(new StringBuilder(), visited);

        return answer.size();
    }
    
    private void dfs(StringBuilder sb, boolean[] visited) {
        if(sb.length() > 0) {
            int value = Integer.parseInt(sb.toString());
            if(!answer.contains(value) && isPrime[value]) answer.add(value);
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
    
    private void primeNumberSieve(int max) {
        isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2; i<=Math.sqrt(max); i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=max; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}

/*
완전 탐색 문제 인듯 하다

25.09.30
에라토스테네스의 체 적용
이전 7.79ms

*/