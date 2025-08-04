class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char c : my_string.toCharArray()) answer[(c>='a') ? c-'a'+26 : c-'A']++;
        return answer;
    }
}