class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[0] = Integer.MAX_VALUE; 
        answer[1] = Integer.MAX_VALUE;
        
        for(int y=0; y<wallpaper.length; y++) {
            for(int x=0; x<wallpaper[0].length(); x++) {
                if(wallpaper[y].charAt(x)!='#') continue;
                
                if(y<answer[0]) answer[0]=y;
                if(x<answer[1]) answer[1]=x;
                
                if(y>answer[2]) answer[2]=y;
                if(x>answer[3]) answer[3]=x;
            }
        }
        
        answer[2]++; 
        answer[3]++;
        return answer;
    }
}