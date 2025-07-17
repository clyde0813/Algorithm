import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] pos = getStart(park);

        for(String route : routes)  pos = move(park, pos, route);
        
        return pos;
    }
    
    private int[] getStart(String[] park) {
        int[] start = new int[2];
        for(int y=0; y<park.length; y++) {
            for(int x=0; x<park[0].length(); x++) {
                if(park[y].charAt(x)=='S') {
                    start[0] = y;
                    start[1] = x;
                    return start;
                }
            }
        }
        return start;
    }
    
    private int[] move(String[] park, int[] pos, String route) {
        char dir = route.charAt(0);
        int n = park.length, m = park[0].length();
        int dy = pos[0], dx = pos[1];
        
        for(int i=0; i<Integer.valueOf(route.charAt(2)-'0'); i++) {
            if(dir=='N') dy--;
            else if(dir=='S')  dy++;
            else if(dir=='W') dx--;
            else dx++;
            
            if(!(n>dy && dy>=0 && m>dx && dx>=0) || (park[dy].charAt(dx)=='X')) return pos;
        }
        
        return new int[]{dy, dx};
    }
}