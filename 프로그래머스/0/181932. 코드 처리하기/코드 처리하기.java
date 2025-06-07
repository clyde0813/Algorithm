class Solution {
    public String solution(String code) {
        char[] arr = code.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean status = true;
        
        for(int i=0; i<code.length(); i++) {
            if(arr[i]=='1') status = !status;
            else if(status && i%2==0) sb.append(arr[i]);
            else if(!status && i%2==1) sb.append(arr[i]);
        }
        
        if(sb.length()==0) return "EMPTY";
        return sb.toString();
    }
}