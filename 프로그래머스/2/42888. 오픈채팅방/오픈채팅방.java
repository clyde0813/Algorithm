import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> accessLog = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        Map<String, String> uuid = new HashMap<>();
        
        for(String r : record){
            String[] rTmp = r.split(" ");
            if(rTmp[0].equals("Enter")){
                accessLog.add(r);
                uuid.put(rTmp[1], rTmp[2]);
            } else if(rTmp[0].equals("Leave")){
                accessLog.add(r);
            } else if(rTmp[0].equals("Change")){
                uuid.put(rTmp[1], rTmp[2]);
            }
        }
        
        for(String access : accessLog){
            String[] aTmp = access.split(" ");
            String username = uuid.get(aTmp[1]);
            if(aTmp[0].equals("Enter")){
                answer.add(username + "님이 들어왔습니다.");
            } else {
                answer.add(username + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(String[]::new);
    }
}