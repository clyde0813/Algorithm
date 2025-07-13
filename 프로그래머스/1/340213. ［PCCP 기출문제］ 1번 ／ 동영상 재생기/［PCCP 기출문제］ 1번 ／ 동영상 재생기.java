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

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", position/60)).append(":").append(String.format("%02d", position%60));
        
        return sb.toString();
    }
    
    private int stringToInt(String timeString) {
        int result = 0;
        String[] ts = timeString.split(":");
        for(int i=0; i<2; i++) result += Integer.valueOf(ts[i]) * Math.pow(60, (1-i));
        return result;
    }
}