import java.util.*;

class Solution {
    private char[] charNumbers;
    private Set<Integer> answer = new HashSet<>();
    
    public int solution(String numbers) {
        int n = numbers.length();
        boolean[] visited = new boolean[n];
        this.charNumbers = numbers.toCharArray();
        
        for(int i=1; i<=n; i++) {
            char[] arr = new char[i];
            
            dfs(arr, visited, 0);
        }

        return answer.size();
    }
    
    private void dfs(char[] arr, boolean[] visited, int count) {
        if(count == arr.length) {
            int value = charArrayToInt(arr);
            if(isPrime(value)) answer.add(value);
            return;
        }
        
        for(int i=0; i<charNumbers.length; i++) {
            if(visited[i]) continue;
            
            visited[i] = true;
            arr[count] = charNumbers[i];
            dfs(arr, visited, count+1);
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
    
    private int charArrayToInt(char[] arr) {
        return Integer.parseInt(new String(arr));
    }
}

/*
완전 탐색 문제 인듯 하다
중복 안되니까 set으로 정답 관리해야 할듯하고
몇글자 담을지 먼저 정하고 dfs 보내야한다

*/