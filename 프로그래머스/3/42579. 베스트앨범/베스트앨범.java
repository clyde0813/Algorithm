import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<Integer>> music = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            music.computeIfAbsent(genre, k -> new ArrayList<>()).add(i);
            count.put(genre, count.getOrDefault(genre, 0) + play);
        }
        
        List<String> sortedGenre = new ArrayList<>(count.keySet());
        sortedGenre.sort((o1, o2) -> count.get(o2).compareTo(count.get(o1)));
        
        for(String genre : sortedGenre){
            List<Integer> musicList = music.get(genre);
            musicList.sort((o1, o2) -> Integer.compare(plays[o2], plays[o1]));
            System.out.println(musicList);
            answer.add(musicList.get(0));
            if(musicList.size() > 1) answer.add(musicList.get(1));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}