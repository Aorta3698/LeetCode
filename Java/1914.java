class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        rotate(grid, k, 0);
        return grid;
    }

    private void rotate(int[][] grid, int k, int d){
        int m = grid.length, n = grid[0].length, sz = (m - 2 * d) * 2 + (n - 2 * d) * 2 - 4, z = k % sz;
        int[] id = new int[sz];
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        for (int i = d, j = d, cnt = 0, v = 0; cnt < 2 * sz; ++cnt){
            if (cnt < sz){
                id[cnt] = grid[i][j];
            }else{
                grid[i][j] = id[(z + cnt) % sz];
            }
            if (i + dx[v] < d || i + dx[v] == m - d || j + dy[v] < d || j + dy[v] == n - d){
                v = (v + 1) % 4;
            }
            i += dx[v];
            j += dy[v];
        }
        if (Math.min(m, n) > ++d * 2){
            rotate(grid, k, d);
        }
    }
}
