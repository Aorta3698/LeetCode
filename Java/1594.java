https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/discuss/1925011/Java-or-Simple-DFS-with-BitMask-or-8ms
class Solution {
    public int maxProductPath(int[][] grid) {
        boolean[][][] seen = new boolean[grid.length][grid[0].length][1 << 12];
        return (int)(dfs(0, 0, 0, grid, seen) % (int)(1e9 + 7));
    }

    private long dfs(int i, int j, int cur, int[][] grid, boolean[][][] seen){
        if (i == grid.length || j == grid[0].length || seen[i][j][cur])
            return -1;

        seen[i][j][cur] = true;
        if (grid[i][j] == 0)
            return 0;

        int abs = Math.abs(grid[i][j]);
        if (grid[i][j] < 0){
            cur ^= 1;
        }
        if (abs == 2){
            cur += (1 << 1);
        }else if (abs == 3){
            cur += (1 << 7);
        }else if (abs == 4){
            cur += (1 << 2);
        }

        return i + j + 2 == grid.length + grid[0].length? score(cur) :
            (long)(Math.max(dfs(i + 1, j, cur, grid, seen), dfs(i, j + 1, cur, grid, seen)));
    }

    private long score(int n){
        if ((n & 1) > 0)
            return -1;
        n >>= 1;
        return (long)(Math.pow(2, n % (1 << 6)) * Math.pow(3, n >> 6));
    }
}
