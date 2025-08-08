class Solution {
    public String solution(String X, String Y) {
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(char x : X.toCharArray()) xArr[x-'0']++;
        for(char y : Y.toCharArray()) yArr[y-'0']++;
        
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--) {
            if(Math.min(xArr[i], yArr[i])>0) {
                for(int j=0; j<Math.min(xArr[i], yArr[i]); j++) sb.append(i);
            }
        }
        
        String answer = sb.toString();
        if(answer.length()==0) return "-1";
        else if(answer.charAt(0)=='0') return "0";
        else return answer;
    }
}