import java.util.*;

class Solution {
    private int n, m;
    private int[][] dirs = {{-1,-1},{-1,0},{0,-1}}; 
    
    public int solution(int[] mats, String[][] park) {
        this.n = park.length;
        this.m = park[0].length;
        int[][] map = createMap(park);
        int max = getMaxSize(map);
        System.out.println(max);
        int maxMat = getMaxMat(max, mats);
        
        return maxMat;
    }
    
    private int[][] createMap(String[][] park) {
        int[][] map = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(park[i][j].equals("-1")) map[i][j] = 1;
                else map[i][j] = -1;
            }
        }
        
        return map;
    }
    
    private int getMaxSize(int[][] map) {
        int max = 0;
        
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(map[i][j]==-1) continue;
                
                int min = Integer.MAX_VALUE;
                for(int[] dir : dirs) {
                    int dy = i+dir[0], dx = j+dir[1];
                    if(map[dy][dx] == -1) {
                        min = 0;
                        break;
                    }
                    min = Math.min(min, map[dy][dx]);
                }
                map[i][j] = min + 1;
                max = Math.max(max, min + 1);
            }
        }
                
        return max;
    }
    
    private int getMaxMat(int max, int[] mats) {
        Arrays.sort(mats);
        int idx = Arrays.binarySearch(mats, max);
        if(idx<0) idx = -idx-2;
        return idx<0 ? -1 : mats[idx];
    }
}