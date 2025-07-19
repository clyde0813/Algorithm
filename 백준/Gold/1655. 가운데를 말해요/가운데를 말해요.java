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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> leftHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());

            if (i == 0) leftHeap.offer(value);

            else if (leftHeap.size() == rightHeap.size()) {
                int temp = rightHeap.poll();
                rightHeap.offer(temp);
                if (temp >= value) leftHeap.offer(value);
                else {
                    leftHeap.offer(rightHeap.poll());
                    rightHeap.offer(value);
                }
            }

            else {
                int temp = leftHeap.poll();
                leftHeap.offer(temp);
                if (temp <= value) {
                    rightHeap.offer(value);
                } else {
                    rightHeap.offer(leftHeap.poll());
                    leftHeap.offer(value);
                }
            }

            value = leftHeap.poll();
            leftHeap.offer(value);
            bw.write(String.valueOf(value));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}