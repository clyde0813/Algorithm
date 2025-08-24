import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        list.sort((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s2+s1).compareTo(s1+s2);
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            if(i==0 && list.get(i)==0) {
                sb.append(0);
                break;
            }
            sb.append(list.get(i));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}