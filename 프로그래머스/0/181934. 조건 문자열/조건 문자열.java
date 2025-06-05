class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean answer = true;
        
        StringBuilder sb = new StringBuilder();
        sb.append(ineq).append(eq);
        String sign = sb.toString();
        
        if(sign.equals(">=")) answer = n>=m;
        else if(sign.equals(">!")) answer = n>m;
        else if(sign.equals("<=")) answer = n<=m;
        else answer = n<m;
        
        return answer ? 1 : 0;
    }
}