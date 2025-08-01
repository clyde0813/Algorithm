class Solution {
    public int solution(int[] ingredient) {
        int[] stack = new int[ingredient.length];
        int pointer = -1;
        int answer = 0;
        for(int i : ingredient) {
            stack[++pointer] = i;
            if(pointer >= 3 &&
               stack[pointer] == 1 &&
               stack[pointer-1] == 3 &&
               stack[pointer-2] == 2 &&
               stack[pointer-3] == 1
              ) {
                answer++;
                pointer -= 4;
            }
        }
        
        return answer;
    }
}
