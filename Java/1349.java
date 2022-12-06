class Solution {
    int[][] DIRS = {{0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
    int m;
    int n;
    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        int ans = 0;
        int[][] match = new int[m][n];
        int[][] seen = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(match[i], -1);
        }
        int rev = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (seats[i][j]=='.'){
                    ans++;
                    if (dfs(i, j, i*n+j+1, seats, match, seen)){
                        rev++;
                    }
                }
            }
        }
        return ans-rev/2;
    }

    private boolean dfs(int i, int j, int v, char[][] seats, int[][] match, int[][] seen){
        if (seen[i][j]==v)
            return false;
        seen[i][j] = v;
        for (int[] d : DIRS){
            int x = d[0] + i;
            int y = d[1] + j;
            if (x < 0 || y < 0 || x == m || y == n || seats[x][y] == '#' || seen[x][y]==v){
                continue;
            }
            if (match[x][y]==-1||dfs(match[x][y]/n, match[x][y]%n, v, seats, match, seen)){
                match[x][y]=i*n+j;
                return true;
            }
        }
        return false;
    }
}
