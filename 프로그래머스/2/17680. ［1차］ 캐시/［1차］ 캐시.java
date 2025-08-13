import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length * 5;
        LinkedHashMap<String, String> cache = new LinkedHashMap<>(cacheSize, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(final Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
        
        int answer = 0;
        for(String city : cities) {
            city = city.toLowerCase();
            answer += (cache.containsKey(city)) ? 1 : 5;
            cache.put(city, null);
        }
        return answer;
    }
}