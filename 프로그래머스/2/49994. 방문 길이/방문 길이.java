import java.util.*;

class Solution {
    private int count = 0;
    private Set<String> set = new HashSet<>();
    private Position position = new Position(0,0);
    
    public int solution(String dirs) {
        for(int i = 0; i<dirs.length(); i++){
            char dir = dirs.charAt(i);
            int pastX = position.getX();
            int pastY = position.getY();
            if(dir == 'U') {
                position.moveUp();
            } else if(dir == 'D') {
                position.moveDown();
            } else if(dir == 'R') {
                position.moveRight();
            } else if(dir == 'L') {
                position.moveLeft();
            }
            roadCount(pastX, pastY, position.getX(), position.getY());
        }
        
        return count;
    }
    
    public void roadCount(int pastX, int pastY, int x, int y){
        if(pastX == x && pastY == y) return;
        StringBuilder sb1 = new StringBuilder();
        sb1.append(pastX).append(pastY).append(x).append(y);
        String road = sb1.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(x).append(y).append(pastX).append(pastY);
        String reverse = sb2.toString();
        if(!set.contains(road) || !set.contains(reverse)){
            set.add(road);
            set.add(reverse);
            count++;
        }
    }
    
    class Position {
        public int x;
        public int y;
        
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public int getX(){
            return this.x;
        }
        
        public int getY(){
            return this.y;
        }
        
        public void moveUp(){
            if(this.y < 5) this.y++;
        }
        
        public void moveDown(){
            if(this.y > -5) this.y--;
        }
        
        public void moveRight(){
            if(this.x < 5) this.x++;
        }
        
        public void moveLeft(){
            if(this.x > -5) this.x--;
        }
    }
    
}