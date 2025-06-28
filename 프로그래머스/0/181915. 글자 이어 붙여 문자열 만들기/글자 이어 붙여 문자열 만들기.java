class Solution {
    public String solution(String my_string, int[] index_list) {
        char[] arr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int idx : index_list) sb.append(arr[idx]);
        return sb.toString();
    }
}