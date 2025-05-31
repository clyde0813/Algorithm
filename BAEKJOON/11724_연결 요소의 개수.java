import java.io.*;
import java.util.*;
​
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        
        int[] parent = new int[nodeCount];
        for(int i=0; i<nodeCount; i++) parent[i] = i;
        
        for(int i=0; i<edgeCount; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            union(parent, start, end);
        }
        
        Set<Integer> answerSet = new HashSet<>();
        for(int i=0; i<parent.length; i++){
            answerSet.add(find(parent, i));
        }
        
        System.out.println(answerSet.size());
    }
    
    private static int find(int[] parent, int target){
        if(parent[target]!=target){
            parent[target] = find(parent, parent[target]);
        }
        return parent[target];
    }
    
    private static void union(int[] parent, int target, int child){
        parent[find(parent, child)] = find(parent, target);
    }
}