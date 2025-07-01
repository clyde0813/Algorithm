class Solution {
    public String solution(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();
        
        for(int[] query : queries) {
            for(int i=query[0]; i<=(query[0]+query[1])/2; i++) {
                char tmp = arr[i];
                arr[i] = arr[query[0]+query[1]-i];
                arr[query[0]+query[1]-i] = tmp;
            }
        }

        return new String(arr);
    }
}