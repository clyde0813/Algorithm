import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        Set<List<Integer>> aliquotSet = new HashSet<>();
        
        // yellow의 약수 집합
        for(int i=1; i <= yellow; i++){
            if(yellow % i == 0){
                List<Integer> tmpList = new ArrayList<>(List.of(i, yellow/i));
                Collections.sort(tmpList);
                aliquotSet.add(tmpList);
            }
        }
        
        int[] answer = new int[2];
        // yellow의 약수 집합으로 brown 조합 찾기
        for(List<Integer> a : aliquotSet) {
            if(brown == a.get(0)*2+4 + a.get(1)*2){
                answer[0] = Math.max(a.get(0) + 2, a.get(1) + 2);
                answer[1] = Math.min(a.get(0) + 2, a.get(1) + 2);
				break;
            }
        }
            
        return answer;
    }
}