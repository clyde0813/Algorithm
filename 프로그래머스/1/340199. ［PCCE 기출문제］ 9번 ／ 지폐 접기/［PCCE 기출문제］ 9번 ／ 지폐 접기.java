class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        while(true) {            
            if(wallet[0]>=bill[0] && wallet[1]>=bill[1]) break;
            else if(wallet[0]>=bill[1] && wallet[1]>=bill[0]) break;
            
            int fold = (bill[0]>bill[1]) ? 0 : 1;
            bill[fold] /= 2;
            
            answer++;
        }
        
        return answer;
    }
}