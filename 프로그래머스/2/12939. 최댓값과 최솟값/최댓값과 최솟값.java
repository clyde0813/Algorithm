class Solution {
    public String solution(String s) {
        String[] strNumbers = s.split(" ");
        
        int min = Integer.parseInt(strNumbers[0]);
        int max = Integer.parseInt(strNumbers[0]);
        
        for (int i = 1; i < strNumbers.length; i++) {
            int num = Integer.parseInt(strNumbers[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return min + " " + max;
    }
}