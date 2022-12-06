https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/discuss/1976496/Java-or-Find-Median-or-Comments
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length, k = grid[0][0] % x;
        int[] arr = new int[m * n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] % x != k)
                    return -1;
                arr[i * n + j] = (grid[i][j] - k) / x;
            }
        }
        Arrays.sort(arr);
        int ans = 0, mid = arr[arr.length / 2];
        for (int i = 0; i < arr.length; i++){
            ans += Math.abs(arr[i] - mid);
        }

        return ans;
    }
}
