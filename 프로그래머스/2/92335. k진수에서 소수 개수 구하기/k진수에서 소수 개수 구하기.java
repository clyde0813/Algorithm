class Solution {
    public int solution(int n, int k) {
        String base = Integer.toString(n, k);  
        int answer = 0;
        int idx = 0;
        
        while(idx<base.length()) {           
            StringBuilder sb = new StringBuilder();
            for(int j=idx; j<base.length()+1; j++) {
                if(j==base.length() || base.charAt(j)=='0') {
                    if(isPrimeNumber(sb.toString())) answer++;                    
                    idx = j+1;
                    break;
                }
                sb.append(base.charAt(j));
            }
        }
        
        return answer;
    }
    
    private boolean isPrimeNumber(String number) {
        if(number.length()==0 || number.equals("1")) return false;
        long n = Long.valueOf(number);
        
        for(int i=2; i<=Math.sqrt(n); i++) if(n%i==0) return false;
        return true;
    }
}