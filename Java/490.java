class Solution {
    int m;
    int n;
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{1, -1, 0, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        return dfs(start[0], start[1], destination[0], destination[1], maze, new boolean[m][n]);
    }

    private boolean dfs(int i, int j, int di, int dj, int[][] maze, boolean[][] seen){
        if (seen[i][j]){
            return false;
        }
        if (i==di&&j==dj){
            return true;
        }
        seen[i][j]=true;
        for (int k = 0; k < 4; k++){
            int x = i;
            int y = j;
            while(withinBounds(x+dx[k],y+dy[k]) && maze[x+dx[k]][y+dy[k]]==0){
                x+=dx[k];
                y+=dy[k];
            }
            if (dfs(x, y, di, dj, maze, seen)){
                return true;
            }
        }
        return false;
    }

    private boolean withinBounds(int i, int j){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
