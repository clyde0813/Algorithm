import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] pronunciation = {"aya", "ye", "woo", "ma"};
        Set<String> set = new HashSet<>();
        for(String p : pronunciation) set.add(p);
        
        int answer = 0;
        for(String babble : babbling) {
            int idx = 0;
            String past = "";
            while(true) {
                int record = idx;
                
                if(
                    (idx+2 <= babble.length() && set.contains(babble.substring(idx, idx+2))) ||
                    (idx+3 <= babble.length() && set.contains(babble.substring(idx, idx+3)))
                    ) {
                    String p = (set.contains(babble.substring(idx, idx+2))) ?
                        babble.substring(idx, idx+2) : babble.substring(idx, idx+3);

                    if(!past.equals(p)) {
                        past = p;
                        idx += p.length();
                    }
                }

                if(record==idx) break;
                else if(idx==babble.length()) {
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}