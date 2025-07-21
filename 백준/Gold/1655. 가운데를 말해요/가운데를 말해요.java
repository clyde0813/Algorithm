import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        new Main().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if(left.isEmpty() || value <= left.peek()) left.offer(value);
            else right.offer(value);

            if (left.size() - right.size() > 1) right.offer(left.poll());
            else if (left.size() < right.size()) left.offer(right.poll());

            bw.write(String.valueOf(left.peek()));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}