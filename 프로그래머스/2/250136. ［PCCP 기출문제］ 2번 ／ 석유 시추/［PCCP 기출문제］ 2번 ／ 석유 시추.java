import java.util.*;

class Solution {
    private int[][] land;
    private int n,m;
    private Map<Integer, Integer> groupAmounts = new HashMap<>();
    private Map<Integer, Set<Integer>> columnGroups = new HashMap<>();
    private boolean[][] visited;
    private int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    public int solution(int[][] land) {
        this.land = land;
        m = land[0].length;
        n = land.length;
        this.visited = new boolean[n][m];
        int groupId = 1;
        int answer = 0;
        
        for(int x=0; x<m; x++){
            for(int y=0; y<n; y++){
                if(land[y][x]==1&&visited[y][x]==false){
                    Deque<int[]> stack = new ArrayDeque<>();
                    stack.addFirst(new int[]{y, x});
                    while(!stack.isEmpty()){
                        int[] s = stack.pollFirst();
                        int yy = s[0], xx = s[1];
                        if(isInBound(yy,xx)&&land[yy][xx]==1&&visited[yy][xx]==false){
                            visited[yy][xx] = true;
                            land[yy][xx] = groupId;
                            groupAmounts.put(groupId, groupAmounts.getOrDefault(groupId, 0)+1);
                            columnGroups.computeIfAbsent(xx, o -> new HashSet()).add(groupId);
                            for(int[] dir : dirs){
                                stack.add(new int[]{yy+dir[0], xx+dir[1]});
                            }
                        }
                    }
                    groupId++;
                }
            }
        }

        for(Set<Integer> groups : columnGroups.values()){
            int amount = 0;
            for(Integer group : groups){
                amount += groupAmounts.get(group);
            }
            answer = Math.max(amount, answer);
        }
                
        return answer;
    }
    
    public boolean isInBound(int y, int x){
        if(m <= x || 0 > x || n <= y || 0 > y){
            return false;
        }
        return true;
    }
}