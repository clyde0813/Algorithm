class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            int pivot = addMinutes(schedules[i], 10);
            int day = startday;
            boolean flag = true;
            
            for(int timelog : timelogs[i]) {    
                if(day != 6 && day != 7 && timelog > pivot){
                    flag = false; 
                    break;
                } 
                if(day++ == 7) day = 1;
            }
            if(flag) answer++;
        }
        
        return answer;
    }
    
    private int addMinutes(int base, int minutes) {
        base += minutes;
        if(base % 100 >= 60) {
            base += 100;
            base -= 60;
        }
        
        return base;
    }
}