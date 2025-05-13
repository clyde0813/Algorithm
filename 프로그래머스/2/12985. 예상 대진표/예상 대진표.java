class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        while(true){
            if((int) (a+1)/2 == (int) (b+1)/2) return answer;
            a = (int) (a + 1) / 2;
            b = (int) (b + 1) / 2;
            answer++;
        }
    }
}