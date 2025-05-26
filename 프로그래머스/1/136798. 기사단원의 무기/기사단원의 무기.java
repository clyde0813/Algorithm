class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        for(int i=2; i<number+1; i++){
            int kPower = 0;
            for(int j=1; j*j<i+1; j++){
                if(j*j==i) kPower += 1;
                else if(i%j==0) kPower += 2;
            }
            if(kPower>limit) answer += power;
            else answer += kPower;
        }
        return answer;
    }
}