https://leetcode.com/problems/where-will-the-ball-fall/discuss/1624563/Java-or-Simulate-The-Process-For-Each-Ball-or-0ms
class Solution {
    public int[] findBall(int[][] grid) {
        int[] ans = new int[grid[0].length];

        for (int i = 0; i < ans.length; i++)
            ans[i] = search(grid, i, 0);

        return ans;
    }

    private int search(int[][] grid, int idx, int row){
        if (row == grid.length) return idx;
        if (grid[row][idx] == 1 && (idx == grid[0].length - 1 || grid[row][idx + 1] == -1)
                || (grid[row][idx] == -1 && (idx == 0 || grid[row][idx - 1] == 1)))
            return -1;

        return grid[row][idx] == 1?
            search(grid, idx + 1, row + 1) : search(grid, idx - 1, row + 1);
    }
}
