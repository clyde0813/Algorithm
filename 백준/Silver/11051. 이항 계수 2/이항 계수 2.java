import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    
    private int[][] cache;
    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());
        this.cache = new int[n+1][k+1];

        System.out.println(pascalDFS(n, k));
    }

    private int pascalDFS(int n, int r) {
        if(r==0 || n==r) return cache[n][r] = 1;
        if(cache[n][r]>0) return cache[n][r];
        return cache[n][r] = (pascalDFS(n-1, r-1) + pascalDFS(n-1, r)) % 10007;
    }
}