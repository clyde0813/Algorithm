import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1];
        int[][] arr = new int[n+1][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        for(int i=1; i<n+1; i++) {
            int[] current = arr[i];
            int w = current[0];
            int v = current[1];

            for(int j=1; j<k+1; j++) {
                if(j<w) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w]+v);
            }
        }

        bw.write(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
    }
}