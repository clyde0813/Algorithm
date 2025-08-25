import java.util.*;

class Solution {
    private int[] fees;
    public int[] solution(int[] fees, String[] records) {
        this.fees = fees;
        Map<String, Integer> timeCountMap = recordsToTimeCountMap(records);
        Map<String, Integer> feeMap = timeCountMapToFeeMap(timeCountMap);
        int[] answer = feeMapToAnswer(feeMap);

        return answer;
    }
    
    private int timeToInt(String time) {
        int[] arr = Arrays.stream(time.split(":")).mapToInt(Integer::parseInt).toArray();
        return arr[0] * 60 + arr[1];
    }
    
    private Map<String, Integer> recordsToTimeCountMap(String[] records) {
        Map<String, Integer> timeCountMap = new HashMap<>();
        Map<String, Integer> timeLogMap = new HashMap<>();
        
        for(String record : records) {
            String[] log = record.split(" ");
            int time = timeToInt(log[0]);
            String carNumber = log[1];
            boolean status = (log[2].equals("IN")) ? true : false;
            
            if(!status) {
                int exist = timeCountMap.getOrDefault(carNumber, 0);
                int inTime = timeLogMap.get(carNumber);
                timeLogMap.remove(carNumber);
                timeCountMap.put(carNumber, exist + (time - inTime));
                continue;
            }
            timeLogMap.put(carNumber, time);
        }
        
        if(!timeLogMap.isEmpty()) {
            for(String key : timeLogMap.keySet()) {
                int exist = timeCountMap.getOrDefault(key, 0);
                int inTime = timeLogMap.get(key);
                timeCountMap.put(key, exist + (1439 - inTime));
            }
        }
        
        return timeCountMap;
    }
    
    private Map<String, Integer> timeCountMapToFeeMap(Map<String, Integer> timeCountMap) {
        Map<String, Integer> feeMap = new HashMap<>();

        for(String key : timeCountMap.keySet()) {
            int time = timeCountMap.get(key);
            int chargingTime = time - fees[0];
            int chargingFee = (chargingTime > 0) ? 
                fees[1] + (((chargingTime + (fees[2] - 1)) / fees[2]) * fees[3]) 
                : fees[1];
            feeMap.put(key, chargingFee);
        }
        
        return feeMap;
    }
    
    private int[] feeMapToAnswer(Map<String, Integer> feeMap) {
        int size = feeMap.size();
        int[] answer = new int[size];
        List<Integer> keys = new ArrayList(feeMap.keySet());
        Collections.sort(keys);
        
        for(int i=0; i<size; i++) {
            answer[i] = feeMap.get(keys.get(i));
        }
    
        return answer;
    }
}