import java.util.*;

class Solution {
    private int length, answer = -1;
    private int[] WEAK;
    private boolean[] used;
    
    public int solution(int n, int[] weak, int[] dist) {
        this.length = weak.length;
        this.WEAK = new int[length*2];
        for(int i=0; i<2; i++) {
            for(int j=0; j<length; j++) {
                WEAK[length*i + j] = weak[j] + n*i;
            }
        }
        
        Arrays.sort(dist);
        for(int i=0; i<dist.length/2; i++) {
            int temp = dist[i];
            dist[i] = dist[dist.length-i-1];
            dist[dist.length-i-1] = temp;
        }
        
        used = new boolean[dist.length];
        for(int i=1; i<=dist.length; i++) {
            int[] org = Arrays.copyOf(dist, i);
            permutation(0, new int[i], org);
            if(answer>0) return answer;
        }
        
        return answer;
    }
    
    private void permutation(int n, int[] dist, int[] org) {
        if(n==org.length) {
            if(check(dist)) answer = n;
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
    
    private boolean check(int[] dist) {
        for(int i=0; i<length; i++) {
            int idx = i;
            for(int distance : dist) {
                int pos = WEAK[idx++] + distance;
                while(idx<WEAK.length && WEAK[idx]<=pos) idx++;
            }
            if(idx-i>=length) return true;
        }
        return false;
    }
}