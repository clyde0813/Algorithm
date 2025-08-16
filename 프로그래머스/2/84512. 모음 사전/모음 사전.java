class Solution {
    private String word;
    private int answer = 0;
    private final char[] arr = {'A','E','I','O','U'};
    
    public int solution(String word) {
        this.word = word;
        
        dfs(new StringBuilder());
        return answer;
    }
    
    private boolean dfs(StringBuilder sb) {
        if(sb.length()==word.length() && sb.toString().equals(word)) return true;
        if(sb.length() == 5) return false;
        
        for(char c : arr) {
            answer++;
            if(dfs(sb.append(c))) return true;
            sb.deleteCharAt(sb.length()-1);
        }
        
        return false;
    }
}