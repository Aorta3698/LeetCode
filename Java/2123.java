https://leetcode.com/problems/minimum-operations-to-remove-adjacent-ones-in-matrix/discuss/2189213/Concise-Kuhn's-algo-21ms-(95)-Java
class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    int m;
    int n;
    public int minimumOperations(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0, count = 0;
        int[][] match = new int[m][n];
        for (int i = 0; i < m; i++){
            Arrays.fill(match[i], -1);
        }
        int[][] seen = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j]>0&&dfs(i, j, ++count, grid, match, seen)){
                    ans++;
                }
            }
        }

        return ans/2;
    }

    private boolean dfs(int i, int j, int visited, int[][] grid, int[][] match, int[][] seen){
        if (seen[i][j] == visited)
            return false;
        seen[i][j]=visited;
        for (int k = 0; k < 4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if (x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0 || seen[x][y] == visited){
                continue;
            }
            if (match[x][y]==-1||dfs(match[x][y]/n, match[x][y]%n, visited, grid, match, seen)){
                match[x][y]=i*n+j;
                return true;
            }
        }
        return false;
    }
}
