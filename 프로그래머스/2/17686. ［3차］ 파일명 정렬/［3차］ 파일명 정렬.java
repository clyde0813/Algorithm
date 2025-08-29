import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String[]> pq = new LinkedList<>();
        
        for(String file : files) {
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            String tail = "";
            
            int status = 0;
            for(int i=0; i<file.length(); i++) {
                char c = file.charAt(i);
                
                if(status == 0 && Character.isDigit(c)) status++;
                if(status == 1 && !Character.isDigit(c)) status++;
                
                if(status == 0) head.append(c);
                if(status == 1) number.append(c);
                if(status >  1) {
                    tail = file.substring(i, file.length());
                    break;
                }
            }
            pq.add(new String[]{head.toString(), number.toString(), tail.toString()});
        }
        
        Collections.sort(pq, (o1, o2) -> {
            String head1 = o1[0].toLowerCase();
            String head2 = o2[0].toLowerCase();
            
            Integer number1 = Integer.valueOf(o1[1]);
            Integer number2 = Integer.valueOf(o2[1]);
            
            if(head1.equals(head2)) return (number1).compareTo(number2);
            return (head1).compareTo(head2);
        });
        
        String[] answer = new String[files.length];
        
        for(int i=0; i<pq.size(); i++) {
            answer[i] = String.join("", pq.get(i));
        }
        
        return answer;
    }
}