https://leetcode.com/problems/minimize-maximum-value-in-a-grid/discuss/2436328/Java-or-Simple-8-Lines-or-Simplified-from-1632-with-explanations
class Solution {
    public int[][] minScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] idx = IntStream.range(0, m*n).boxed().sorted(Comparator.comparingInt(o -> grid[o/n][o%n])).mapToInt(o -> o).toArray();
        int[] rowMin = new int[m];
        int[] colMin = new int[n];
        int[][] ans = new int[m][n];
        for (int i = 0; i < m*n; i++){
            int x = idx[i]/n, y = idx[i]%n;
            ans[x][y] = rowMin[x] = colMin[y] = Math.max(rowMin[x], colMin[y])+1;
        }
        return ans;
    }
}
