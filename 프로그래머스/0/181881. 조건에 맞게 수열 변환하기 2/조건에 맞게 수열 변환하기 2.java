class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        
        while(true) {
            boolean status = false;
            for(int i=0; i<arr.length; i++) {
        		if(50<arr[i] && arr[i]%2==0) {
                    status = true;
                    arr[i] /= 2;
                }
                else if(50>arr[i] && arr[i]%2==1) {
                    status = true;
                    arr[i] = arr[i] * 2 + 1;
                }
            }
            if(!status) return answer;
            answer++;
        }
    }
}