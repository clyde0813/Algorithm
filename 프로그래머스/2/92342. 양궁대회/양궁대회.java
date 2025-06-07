import java.util.*;

class Solution {
    private static int[] best;
    private static int maxDiff;
    private static int[] apeach;

    public int[] solution(int n, int[] info) {
        apeach = info;
        best = new int[11];
        maxDiff = 0;
        dfs(0, n, new int[11], 0, 0);
        return maxDiff == 0 ? new int[]{-1} : best;
    }

    private static void dfs(int idx, int remain, int[] ryan, int apeachScore, int ryanScore) {
        if (idx == 11) {
            int[] candidate = ryan.clone();
            candidate[10] += remain;

            int diff = ryanScore - apeachScore;
            if (diff <= 0) return;

            if (diff > maxDiff || (diff == maxDiff && isBetter(candidate))) {
                maxDiff = diff;
                best = candidate;
            }
            return;
        }

        // Case 1: ryan가 이 점수를 포기
        dfs(idx + 1, remain, ryan, 
            apeach[idx] > 0 ? apeachScore + (10 - idx) : apeachScore, 
            ryanScore);

        // Case 2: ryan가 이 점수를 이긴다
        int need = apeach[idx] + 1;
        if (remain >= need) {
            ryan[idx] = need;
            dfs(idx + 1, remain - need, ryan, apeachScore, ryanScore + (10 - idx));
            ryan[idx] = 0; // backtrack
        }
    }

    private static boolean isBetter(int[] candidate) {
        for (int i = 10; i >= 0; i--) {
            if (candidate[i] > best[i]) return true;
            else if (candidate[i] < best[i]) return false;
        }
        return false;
    }
}
