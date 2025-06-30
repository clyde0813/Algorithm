class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while(!s.equals("1")) {
            int cnt = 0;
            for(char c : s.toCharArray()) if(c=='1') cnt++;
            answer[0]++;
            answer[1] += s.length()-cnt;
            s = Integer.toBinaryString(cnt);
        }
        
        return answer;
    }
}