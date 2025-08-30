import java.util.*;

class Solution {
    private int m, n;
    private int answer = 0;
    private int[][] dirs = {{1,0}, {0,1}, {1,1}};
    
    public int solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        
        char[][] convertedBoard = new char[m][n];
        for(int i=0; i<m; i++) convertedBoard[i] = board[i].toCharArray();
        
        run(convertedBoard);
        
        return answer;
    }
    
    private void run(char[][] board) {
        
        while(true) {
            boolean status = false;
            Set<List<Integer>> coordinatesToRemove = new HashSet<>();
            
            for(int y=0; y<m-1; y++) {
                for(int x=0; x<n-1; x++) {
                    if(checkBox(y, x, coordinatesToRemove, board)) status = true;
                }
            }
            
            if(!status) break;

            answer += coordinatesToRemove.size();
            board = newBoard(coordinatesToRemove, board);
        }
    }
    
    private boolean checkBox(int y, int x, Set<List<Integer>> coordinatesToRemove, char[][] board) {
        
        boolean status = true;
        char pivot = board[y][x];
        if(pivot == '\0') return false;
        
        for(int[] dir : dirs) {
            int dy = y + dir[0], dx = x + dir[1];
            if(pivot != board[dy][dx]) {
                status = false;
                break;
            }
        }
        
        if(status) {
            coordinatesToRemove.add(Arrays.asList(y, x));
            for(int[] dir : dirs) coordinatesToRemove.add(Arrays.asList(y+dir[0], x+dir[1]));
        }
        
        return status;
    }
    
    private char[][] newBoard(Set<List<Integer>> coordinatesToRemove, char[][] board) {
        char[][] nb = new char[m][n];

        for(int x=0; x<n; x++) {
            int dy = m-1;
            for(int y=m-1; y>=0; y--) {
                if(coordinatesToRemove.contains(Arrays.asList(y, x))) continue;

                nb[dy--][x] = board[y][x];
            }
        }
        
        return nb;
    }
    
    private boolean isAvailable(int y, int x) {
        return m > y && y >= 0 && n > x && x >= 0;
    }
}

/*
블록은 2x2 크기 고정 y 범위 0 ~ .length - 2
동일 라운드에서는 블록 중복 사용 가능
라운드 종료시 나머지 블록의 위치는 변한다.
지울 2x2 블록이 없으면 종료
문제 1. 변하는 블록의 위치를 하나씩 다 보정 해야하는가?
        사라진 블록들 위에 있는 블록들의 위치 보정을 어떻게 할까? - 한줄씩 처리?
        차라리 새로운 판을 만들어서 넘기는건? - 한줄씩 읽으며 남은 블록을 일렬로 정렬하기
문제 2. 중복 블록을 두번 세어서는 안된다. - Set에 좌표들을 넣고 세자.

1. 해당 2x2 블록이 동일한가 체킹 메서드 - return boolean
2. 새로운 판을 만드는 메서드 - return String[][]
*/