import java.util.*;

class Solution {
    private static int length, answer;
    private static int[] WEAK;
    private static boolean[] used;
    
    public int solution(int n, int[] weak, int[] dist) {
        length = weak.length;
        WEAK = new int[length * 2];
        for(int i=0; i<2; i++) {
            for(int j=0; j<length; j++) {
                WEAK[j + (i*length)] = weak[j] + (i*n);
            }
        }

        Arrays.sort(dist);
        for(int i=0; i<dist.length/2; i++) {
            int temp = dist[i];
            dist[i] = dist[dist.length-1-i];
            dist[dist.length-1-i] = temp;
        }

        answer = -1;
        used = new boolean[dist.length];
        
        for(int i=1; i<=dist.length; i++) {
            int[] org = Arrays.copyOf(dist, i);
            permutation(0, new int[i], org);
            if(answer>0) return answer;
        }
        
        return -1;
    }
    
    private static void permutation(int n, int[] dist, int[] org) {
        if(n==org.length) {
            if(isAvailable(dist)) answer = n;
            return;
        }
        
        for(int i=0; i<org.length; i++) {
            if(used[i]) continue;
            used[i] = true;
            dist[n] = org[i];
            permutation(n+1, dist, org);
            used[i] = false;
        }
        return;
    }
    
    private static boolean isAvailable(int[] dist) {
        for(int i=0; i<length; i++) {
            int idx=i;
            for(int distance : dist) {
                int pos = WEAK[idx++] + distance;
                while(idx<WEAK.length && WEAK[idx]<=pos) idx++;
            }
            if(idx-i>=length) return true;
        }
        return false;
    }
}