import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length * 5;
        
        Deque<String> LRU = new ArrayDeque<>();
        Set<String> cache = new HashSet<>();
        
        int answer = 0;
        for(String city : cities) {
            city = city.toLowerCase();
            if(cache.contains(city)) {
                answer += 1;
                LRU.remove(city);
                LRU.offerFirst(city);
            }
            else {
                if(cache.size() == cacheSize) cache.remove(LRU.pollLast());
                answer += 5;
                cache.add(city);
                LRU.offerFirst(city);
            }
        }
        
        return answer;
    }
}