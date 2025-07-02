class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int halfWidth  = board[0] / 2;
        int halfHeight = board[1] / 2;

        int x = 0, y = 0;

        for (String key : keyinput) {
            int nx = x, ny = y;
            switch (key) {
                case "up"   -> ny++;
                case "down" -> ny--;
                case "left" -> nx--;
                case "right"-> nx++;
                default      -> {}  
            }
            
            if (Math.abs(nx) <= halfWidth && Math.abs(ny) <= halfHeight) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}