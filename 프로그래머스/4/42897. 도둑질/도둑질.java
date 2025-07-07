import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;
        if(n==3) return Arrays.stream(money).max().getAsInt();
        
        int[] moneyCopy = Arrays.copyOf(money, money.length);
        for(int i=2; i<money.length; i++) {
            if(i-3>=0) moneyCopy[i] = Math.max(moneyCopy[i-2], moneyCopy[i-3]) + moneyCopy[i];
            else moneyCopy[i] = moneyCopy[i-2] + moneyCopy[i];
        }
        
        int value1 = Math.max(moneyCopy[money.length-3], moneyCopy[money.length-2]);
        
        for(int i=3; i<money.length; i++) {
            if(i-4>=0) money[i] = Math.max(money[i-2], money[i-3]) + money[i];
            else money[i] = money[i-2] + money[i];
        }
        
        int value2 = Math.max(money[money.length-2], money[money.length-1]);
        
        return Math.max(value1, value2);
    }
}