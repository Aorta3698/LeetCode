https://leetcode.com/problems/matrix-cells-in-distance-order/discuss/1636669/Java-Sort-based-on-distance-array
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] dist = new int[rows][cols];
        int[][] ans = new int[rows * cols][2];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                dist[i][j] = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                ans[i * cols + j] = new int[]{i, j};
            }
        }

        Arrays.sort(ans, Comparator.comparingInt(o -> dist[o[0]][o[1]]));
        return ans;
    }
}
