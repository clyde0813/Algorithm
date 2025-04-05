import java.util.*;

class Solution {
    public int solution(String dirs) {
        Set<String> visited = new HashSet<>();
        Position pos = new Position(0, 0);
        int count = 0;
        
        for(char dir : dirs.toCharArray()) {
            int prevX = pos.x;
            int prevY = pos.y;
            
            pos.move(dir);
            
            int currX = pos.x;
            int currY = pos.y;

            if(prevX != currX || prevY != currY){
                if(isNewPath(prevX, prevY, currX, currY, visited)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isNewPath(int x1, int y1, int x2, int y2, Set<String> visited){
        StringBuilder sb1 = new StringBuilder();
        sb1.append(x1).append(y1).append(x2).append(y2);
        String path1 = sb1.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(x2).append(y2).append(x1).append(y1);
        String path2 = sb2.toString();
        
        if(!visited.contains(path1)){
            visited.add(path1);
            visited.add(path2);
            return true;
        }
        return false;
    }
    
    static class Position {
        int x;
        int y;
        
        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        void move(char dir){
            switch (dir) {
                case 'U':
                    if(y < 5) y++;
                    break;
                case 'D':
                    if(y > -5) y--;
                    break;
                case 'R':
                    if(x < 5) x++;
                    break;
                case 'L':
                    if(x > -5) x--;
                    break;
            }
        }
    }
}