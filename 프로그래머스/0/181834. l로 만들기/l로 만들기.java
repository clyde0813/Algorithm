class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : myString.toCharArray()) sb.append(((int) c > 108) ? c : 'l');
        
        return sb.toString();
    }
}