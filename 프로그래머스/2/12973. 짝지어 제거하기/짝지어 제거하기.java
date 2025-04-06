class Solution
{
    public int solution(String s)
    {
        char[] arr = new char[s.length()];
        int answer = -1;
        for(char c : s.toCharArray()){
            if(answer > -1 && arr[answer] == c) answer--;
            else arr[++answer] = c;
        }
        return (answer == -1) ? 1 : 0;
    }
}