import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = stringToInt(video_len);
        int position = stringToInt(pos);
        int opStart = stringToInt(op_start);
        int opEnd = stringToInt(op_end);
        
        for(String command : commands) {
            if(position>=opStart && position<=opEnd) position = opEnd;
            if(command.equals("next")) {
                position += 10;
                if(position>videoLen) position = videoLen;
            }
            else if(command.equals("prev")) {
                position -= 10;
                if(position<0) position = 0;
            }
        }
        if(position>=opStart && position<=opEnd) position = opEnd;
        
        return String.format("%02d:%02d", position/60, position%60);
    }
    
    private int stringToInt(String string) {
        String[] p = string.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }
}