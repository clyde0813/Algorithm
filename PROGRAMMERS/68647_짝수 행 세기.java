import java.util.*;

public class Solution {
    private static final int MOD = 10_000_019;  // 10^7 + 19

    public int solution(int[][] a) {
        int H = a.length;        // 행의 수
        int W = a[0].length;     // 열의 수

        // 1) 각 열마다 1의 개수(c_j)를 센다.
        int[] colCount = new int[W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (a[i][j] == 1) {
                    colCount[j]++;
                }
            }
        }

        // 2) 이항계수 C[n][k] 테이블을 Pascal 삼각형 DP로 채운다. (0 <= n <= H)
        int[][] C = new int[H + 1][H + 1];
        for (int n = 0; n <= H; n++) {
            C[n][0] = 1;
            C[n][n] = 1;
            for (int k = 1; k < n; k++) {
                C[n][k] = C[n - 1][k - 1] + C[n - 1][k];
                if (C[n][k] >= MOD) {
                    C[n][k] -= MOD;
                }
            }
        }

        // 3) 2^H의 역원을 구한다. (MOD가 홀수이므로, 역원 2^{-1} = (MOD+1)/2)
        int inv2 = (MOD + 1) / 2;  // mod 상에서 2 * inv2 ≡ 1
        int inv2powH = 1;
        for (int i = 0; i < H; i++) {
            inv2powH = (int) ((long) inv2powH * inv2 % MOD);
        }

        // 4) P[s] := s = 0..H 에 대해 ∏_{j=1..W} K_j(s)를 누적할 배열
        int[] P = new int[H + 1];
        Arrays.fill(P, 1);

        // 5) 열 j마다, 모든 s(0..H)에 대한 K_j(s)를 구해서 P[s]에 곱해준다.
        for (int j = 0; j < W; j++) {
            int cj = colCount[j];
            // 이 열 j에 대해, s=0..H마다 K_j(s) 계산
            // K_j(s) = sum_{t=0..min(s,cj)} [(-1)^t * C[s][t] * C[H-s][cj - t]]
            for (int s = 0; s <= H; s++) {
                long Kj = 0;
                // t가 0~min(s, cj)일 때, cj - t <= H - s 도 만족해야 C[H-s][cj - t]이 0이 아님
                int tMax = Math.min(s, cj);
                for (int t = 0; t <= tMax; t++) {
                    int rem = cj - t;
                    if (rem < 0 || rem > (H - s)) {
                        continue;
                    }
                    long ways = (long) C[s][t] * C[H - s][rem] % MOD;
                    if ((t & 1) == 1) {
                        // (-1)^t 이므로 t가 홀수면 음수 처리
                        Kj = (Kj - ways) % MOD;
                    } else {
                        // t가 짝수면 양수
                        Kj = (Kj + ways) % MOD;
                    }
                }
                // 음수 보정
                if (Kj < 0) Kj += MOD;

                // P[s] *= K_j(s) (mod)
                P[s] = (int) ((P[s] * Kj) % MOD);
            }
        }

        // 6) ∑_{s=0..H} C[H][s] * P[s] 를 구한다.
        long total = 0;
        for (int s = 0; s <= H; s++) {
            total = (total + (long) C[H][s] * P[s]) % MOD;
        }

        // 7) (1/2^H) 곱해준다.
        //    => total * inv2powH (mod)
        int answer = (int) (total * inv2powH % MOD);
        return answer;
    }
}
