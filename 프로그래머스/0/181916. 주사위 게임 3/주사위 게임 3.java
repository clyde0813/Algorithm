import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int[] dices = new int[]{a,b,c,d};
        Arrays.sort(dices);
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int dice : dices) map.put(dice, map.getOrDefault(dice, 0)+1);

        switch(map.keySet().size()) {
            case 1:
                answer = dices[0] * 1111;
                break;
            case 2:
                if(map.get(dices[0])==1 || map.get(dices[0])==3) {
                    int[] pq = new int[2];
                    for(int key : map.keySet()) {
                        if(map.get(key)==3) pq[0] = key;
                        else pq[1] = key;
                    }
                    answer = (int) Math.pow((10*pq[0]+pq[1]), 2);
                }
                else {
                    List<Integer> keyList = new ArrayList<>(map.keySet());
                    int p = keyList.get(0);
                    int q = keyList.get(1);
                    answer = (p+q) * Math.abs(p-q);
                }
                break;
            case 3:
                int value = 1;
                for(int key : map.keySet()) if(map.get(key)==1) value *= key;
                answer = value;
                break;
            case 4:
                answer = dices[0];
                break;
        }
        return answer;
    }
}