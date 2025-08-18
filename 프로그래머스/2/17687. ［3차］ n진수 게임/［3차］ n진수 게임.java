class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder base = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        int number = 0;
        while(base.length() < m*t) base.append(Integer.toString(number++, n));
        for(int i=p-1; i<m*t; i+=m) answer.append(base.charAt(i));
        
        return answer.toString().toUpperCase();
    }
}