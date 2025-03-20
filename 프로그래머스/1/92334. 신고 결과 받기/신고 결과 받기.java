import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        Map<String, List<String>> reportLog = new HashMap<>();
        
        for(String r : reportSet){
            String[] users = r.split(" ");
            List<String> reporterList = reportLog.getOrDefault(users[1], new ArrayList<>());
            reporterList.add(users[0]);
            reportLog.put(users[1], reporterList);
        }
        
        Map<String, Integer> mailCounts = new HashMap<>();
        for(String reportee : reportLog.keySet()){
            if(reportLog.get(reportee).size() >= k){
                for(String reporter : reportLog.get(reportee)){
                    mailCounts.put(reporter, mailCounts.getOrDefault(reporter, 0) + 1);
                }
            }
        }
        
        return Arrays.stream(id_list)
            .map(i -> mailCounts.getOrDefault(i, 0))
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}