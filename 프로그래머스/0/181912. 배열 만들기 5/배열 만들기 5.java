import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        // 1) 먼저 조건을 만족하는 개수 세기
        int count = 0;
        for (String str : intStrs) {
            // 범위 검증 (필요 시)
            if (s < 0 || s + l > str.length()) 
                continue;
            int val = Integer.parseInt(str.substring(s, s + l));
            if (val > k) count++;
        }

        // 2) 결과 배열 생성 및 값 채우기
        int[] answer = new int[count];
        int idx = 0;
        for (String str : intStrs) {
            if (s < 0 || s + l > str.length()) 
                continue;
            int val = Integer.parseInt(str.substring(s, s + l));
            if (val > k) {
                answer[idx++] = val;
            }
        }
        return answer;
    }
}
