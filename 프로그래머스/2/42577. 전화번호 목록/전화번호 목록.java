import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (s1, s2) -> s1.length()-s2.length());
        Set<String> numbers = new HashSet<>();
        
        numbers.add(phone_book[0]);
       	int max = phone_book[0].length();
        for(int i=1; i<phone_book.length; i++) {
            String phone = phone_book[i];
            
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            for(char p : phone.toCharArray()) {
                sb.append(p);
                if(numbers.contains(sb.toString())) return false;
				if(cnt++ == max) break;
            }
            
            numbers.add(phone);
            max = phone.length();
        }
        
        return true;
    }
}