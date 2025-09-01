import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        int n = numbers.length;
        long[] answer = new long[n];
        
        for(int i=0; i<n; i++) {
            long number = numbers[i];
            long result = (number % 2 == 0) ? number + 1 : oddFunction(number); 
            answer[i] = result;
        }
        
        return answer;
    }
    
    private long oddFunction(long number) {
        String binary = Long.toString(number, 2);
        char[] binaryArray = binary.toCharArray();
        int length = binary.length();
        
        for(int i=length-2; i>=0; i--) {
            if(binaryArray[i] == '0') {
                number += Math.pow(2, (length - 1) - i) - Math.pow(2, (length - 1) - (i+1));
                return number;
            }
        }
        
        number += Math.pow(2, length) - Math.pow(2, length-1);
        
        return number;
    }
}

/*
x는 양의 정수 - 양의 정수이기 때문에 0은 안됨
f(x) - x 보다 크고 x와 비트가 2개 이하로 다른 수중에 가장 작은 수
* x 보다 크고! 라는 조건이 중요함

정리
1. 비트에 0이 하나라도 있다면 -> 가장 낮은 0을 1로 바꾸면 됨
2. 비트에 0이 없다면? -> 가장 높은 자리 번째 1 을 0으로 그리고 (가장 높은 자리 + 1) 번째 비트를 1로 바꾸어야함

1 2 4 8 16 32
1 3 7 15 31 63

1. 짝수인가? - 첫번째 비트가 무조건 0 임 값에 1을 더하면 됨
2. 홀수인가? - 모름!
*/