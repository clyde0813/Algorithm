import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {    
    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int k = Integer.valueOf(st.nextToken());

        System.out.println(pascalDFS(n, k));
    }

    private int pascalDFS(int n, int r) {
        if(n==1 || r==0 || n-r==0) return 1;
        return pascalDFS(n-1, r-1) + pascalDFS(n-1, r);
    }
}