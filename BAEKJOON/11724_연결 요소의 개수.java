import java.io.*;
import java.util.*;
​
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());
        
        int[][] edges = new int[edgeCount][2];
        for(int i=0; i<edgeCount; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            edges[i] = new int[]{start, end};
        }
        
        int[] parent = new int[nodeCount];
        for(int i=0; i<nodeCount; i++) parent[i] = i;
        
        for(int[] edge : edges){
            union(parent, edge[0], edge[1]);
        }
​
        for(int i=0; i<parent.length; i++){
            find(parent, i);
        }
        
        Set<Integer> answerSet = new HashSet<>();
        for(int p : parent){
            answerSet.add(p);
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