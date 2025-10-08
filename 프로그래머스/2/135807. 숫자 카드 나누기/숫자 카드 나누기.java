import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Set<Integer> set = new HashSet<>();
        
        int min = 0;
        
        min = Arrays.stream(arrayA).max().getAsInt();
        for(int i=min; i>0; i--) {
            if(check(i, arrayA, arrayB)) set.add(i);
        }
        
        min = Arrays.stream(arrayB).max().getAsInt();
        for(int i=min; i>0; i--) {
            if(check(i, arrayB, arrayA)) set.add(i);
        }
        
        return (set.size() == 0) ? 0 : Collections.max(set);
    }
    
    private boolean check(int num, int[] array1, int[] array2) {
        for(int a : array1) if(a%num!=0) return false;
        for(int a : array2) if(a%num==0) return false;
        return true;
    }
}

/*
둘다 구해서 교집합 지우고 가장 큰거 뽑으면 되잖아
*/