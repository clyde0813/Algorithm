import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (s1, s2) -> s1.length()-s2.length());
        Set<String> numbers = new HashSet<>();
        
       	int max = phone_book[0].length();
        for(String phone : phone_book) {
            if(numbers.isEmpty()) {
                numbers.add(phone);
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for(char p : phone.toCharArray()) {
                sb.append(p);
                if(numbers.contains(sb.toString())) return false;
				if(i++==max) break;
            }
            numbers.add(phone);
            max = phone.length();
        }
        
        return true;
    }
}