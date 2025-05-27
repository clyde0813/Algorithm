class Solution {
    public int solution(int n, int w, int num) {
        if(n<=w) return 1;
        if(w==1) return n-num+1;
        int[] nCoord = {getX(n, w), getY(n, w)};
        int[] vCoord = {getX(num, w), getY(num, w)};
        int answer = nCoord[1] - vCoord[1];
        if(nCoord[1]%2==0) return (nCoord[0] >= vCoord[0]) ? answer+1 : answer;
        else return (nCoord[0] <= vCoord[0]) ? answer+1 : answer;
    }
    
    private int getY(int n, int w){
        return (n-1) / w;
    }
    
    private int getX(int n, int w){
        return (getY(n, w)%2==0) ? (n-1) % w : (w-1) - ((n-1)%w);
    }
}