import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private int r, c;
    private boolean[][] map;
    boolean[][] visited;
    private Queue<int[]> borderQueue = new ArrayDeque<>();
    private Queue<int[]> nextQueue = new ArrayDeque<>();
    private int[][] swanPosition = new int[2][2];
    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        new Main().solution();
    }

    public void solution() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        this.r = Integer.parseInt(st.nextToken());
        this.c = Integer.parseInt(st.nextToken());
        this.map = new boolean[r][c];
        this.visited = new boolean[r][c];
        
        createMap();

        nextQueue.add(swanPosition[0]);
        visited[swanPosition[0][0]][swanPosition[0][1]] = true;

        int answer = 0;
        while(true) {
            if(findWay()) break;
            meltdown();
            answer++;
        }

        System.out.println(answer);
    }

    private void createMap() throws Exception {
        int swanCount = 0;
        for(int i=0; i<r; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<c; j++) {
                char chr = arr[j];
                if(chr=='L') swanPosition[swanCount++] = new int[]{i, j};
                map[i][j] = (chr=='X') ? false : true;
                if(map[i][j]) borderQueue.add(new int[]{i,j});
            }
        }
    }

    private void meltdown() {
        int size = borderQueue.size();

        for(int i=0; i<size; i++) {
            int[] position = borderQueue.poll();
            int y = position[0], x = position[1];

            for(int[] dir : dirs) {
                int dy = y + dir[0], dx = x + dir[1];
                if(!isInBound(dy, dx) || map[dy][dx]) continue;
                map[dy][dx] = true;
                borderQueue.offer(new int[]{dy,dx});
            }
        }
    }

    private boolean findWay() {
        Queue<int[]> queue = new ArrayDeque<>();
        
        while(!nextQueue.isEmpty()) {
            int[] position = nextQueue.poll();
            int y = position[0], x = position[1];
            if(swanPosition[1][0]==y&&swanPosition[1][1]==x) return true;

            for(int[] dir : dirs) {
                int dy = y+dir[0], dx = x+dir[1];
                if(!isInBound(dy, dx) || visited[dy][dx]) continue;
                visited[dy][dx] = true;
                if(!map[dy][dx]) queue.add(new int[]{dy, dx});
                else nextQueue.offer(new int[]{dy, dx});
            }
        }

        nextQueue = queue;
        return false;
    }

    private boolean isInBound(int y, int x) {
        return (r>y&&y>=0&&c>x&&x>=0);
    }
}