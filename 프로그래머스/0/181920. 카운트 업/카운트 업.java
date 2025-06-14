class Solution {
    public int[] solution(int start_num, int end_num) {
        int numLength = end_num - start_num + 1;
        int[] answer = new int[numLength];
        for(int i=0; i<numLength; i++) answer[i] = i + start_num;
        return answer;
    }
}