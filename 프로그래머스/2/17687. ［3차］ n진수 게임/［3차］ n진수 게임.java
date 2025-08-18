import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int len = ((t-1)*m) + p;
        char[] arr = new char[len];
        
        int idx = 0;
        int num = 0;
        while(idx<len) {  
            char[] converted = convertToBase(n, num++).toCharArray();

            for(int i=0; i<converted.length; i++) {
                if(idx >= len) break;
                arr[idx++] = converted[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=p-1; i<len; i+=m) sb.append(arr[i]);
        
        return sb.toString();
    }
    
    private String convertToBase(int n, int number) {
        if(number == 0) return "0";
        StringBuilder sb = new StringBuilder();
        
        while(number >= 1) {
            int digit = number % n;
            if(digit>=10) sb.insert(0, (char) ('A' + (digit-10)));
            else sb.insert(0, digit);
            number = number / n;
        }
        
        return sb.toString();
    }
}