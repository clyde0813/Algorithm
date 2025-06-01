import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        
        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        
        int answer = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int py=-n+1; py<n; py++){
                    for(int px=-m+1; px<m; px++){
                        if(py==0&&px==0) {
                            
                            if(Math.sqrt(arr[i][j])%1==0){
                                answer = Math.max(answer, arr[i][j]);
                            }
                            continue;
                        }
                        
                        int count = 0;
                        int value = 0;
                        int dx = j;
                        int dy = i;
                        while(n>dy&&dy>=0&&m>dx&&dx>=0){
                            value += arr[dy][dx] * Math.pow(10, count);

                            if(Math.sqrt(value)%1==0){
                                answer = Math.max(value, answer);
                            }
                            
                            dx += px;
                            dy += py;
                            count++;
                        }
                    }
                }
            }
        }
        
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}