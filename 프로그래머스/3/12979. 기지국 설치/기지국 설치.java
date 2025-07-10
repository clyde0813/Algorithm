import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        int start = 0, end = 0, pivot = 1;
        for(int station : stations) {
            start = station-w<=1 ? 1 : station-w;
            end = station+w>=n ? n : station+w;
            if(start-pivot>0) answer += (start-pivot+2*w) / (2*w+1);
            pivot = end + 1;
        }
        if(end<n) answer += (n-end+2*w) / (2*w+1);


        return answer;
    }
}