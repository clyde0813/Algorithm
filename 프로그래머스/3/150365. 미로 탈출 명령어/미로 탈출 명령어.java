class Solution {
    private int[][] dirs = {{1,0},{0,-1},{0,1},{-1,0}};
    private String[] commands = {"d","l","r","u"};
    private int n, m, r, c, k;
    
    public String solution(int n, int m, int y, int x, int c, int r, int k) {
        if((Math.abs(y-c)+Math.abs(x-r))>k ||
           (k-(Math.abs(y-c)+Math.abs(x-r)))%2==1) return "impossible";
        
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        
        StringBuilder sb = new StringBuilder();
        dfs(y, x, sb);
        
        return sb.toString();
    }
    
    private boolean dfs(int y, int x, StringBuilder route) {
        int remain = k - route.length();
        if((Math.abs(y-c)+Math.abs(x-r)) > remain ||
           (remain-(Math.abs(y-c)+Math.abs(x-r)))%2==1) return false;
        
        if(route.length()==k && y==c && x==r) return true;
        
        for(int i=0; i<4; i++) {
            int[] dir = dirs[i];
            String command = commands[i];
            int dy = y+dir[0], dx = x+dir[1];
            if(!isInBound(dy, dx)) continue;
            
            route.append(command);
            if(dfs(dy, dx, route)) return true;
            route.deleteCharAt(route.length()-1);
        }
        
        return false;
    }
    
    private boolean isInBound(int y, int x) {
        return m>=x && x>=1 && n>=y && y>=1;
    }
}