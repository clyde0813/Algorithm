import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> deque = new ArrayDeque<>();

        for(char c : number.toCharArray()) {
            while(k>0 && !deque.isEmpty() && deque.peekLast() < c) {
                deque.pollLast();
                k--;
            }
            deque.offer(c);
        }
        
        for(int i=0; i<k; i++) deque.pollLast();
        
        StringBuilder answer = new StringBuilder();
        for(char c : deque) answer.append(c);
        
        return answer.toString();
    }
}

/*
탐욕법

한줄정리 : 들어오는대로 담으며 이미 덱에 들어있는 숫자와 비교하며 앞으로 치고 나간다.

1. 이미 덱에 있는 숫자들보다 큰 숫자가 들어오면 최대한 앞으로 꺼내야한다.
2. 왜 최대한일까? 가장 앞으로 꺼내기에는 k가 모자랄수도 있다.
3. 따라서 k가 여유롭다면 가장 앞으로, 그게 아니면 "최대한" 앞으로 꺼낸다.
4. 이미 k가 소진된 상태에서는 그대로 뒤이어 들어온다.
5. k가 남으면? k를 사용할만큼 사용해서 최대치로 이미 만들었다는 뜻이다.
6. 따라서 뒤에서부터 남은 k만큼 잘라내면 된다.
*/