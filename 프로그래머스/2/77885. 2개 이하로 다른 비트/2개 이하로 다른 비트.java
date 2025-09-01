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

홀수인 경우 두개로 나누어진다.
1. 1로 꽉찬 2진수
2. 1번이 아닌 0 비트가 포함된 2진수

1. 1로 꽉차면 2개이하 수정만 가능하기에 - 정리 2번을 따라간다.
2. 여기가 까다로운데, 가장 낮은 0 비트를 찾는다. 해당 비트를 1로 바꾼다. 끝 - 이면 틀린다. 왜?
2개 이하까지 수정 가능하니까. 
가장 낮은 0비트를 1로 바꾸고 해당 0비트보다 한자리 낮은 1비트를 0으로 바꾼다.
설명하자면 11011 이면 27이고 11111 로 만들면 31이다. 
이게 가장 작은가? 아니다
11101 29가 가장 작다. 왜냐 0비트보다 높은 비트를 바꾸면 안된다. 
큰값을 작은값으로 바꾸는거니까 x보다 작아진다.
but 0비트보다 한자리 낮은 비트를 0으로 바꾼다면 낮은수와 낮은수보다 최소한으로 큰 수와 바꾸는 것이다.
8 -> 4로 바꾸는건 안되지만, 4를 그냥 더하는것보다 4를 더하고 2를 빼면 2만 더해지는것이다!
이러면 끝이다.

근데 쉬프트 연산자로 풀면 뭔가 더 빠를것같은데...
*/