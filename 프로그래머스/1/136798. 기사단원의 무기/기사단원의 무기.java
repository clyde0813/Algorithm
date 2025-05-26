class Solution {
    public int solution(int number, int limit, int power) {
        int[] divisorCount = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                divisorCount[j]++;
            }
        }

        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += (divisorCount[i] > limit) ? power : divisorCount[i];
        }

        return answer;
    }
}