https://leetcode.com/problems/grid-game/discuss/1911658/Java-or-prefix-and-suffix-sum-or-with-a-diagram
class Solution {
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE, sum = Arrays.stream(grid[0]).asLongStream().sum(), pre = 0;
        for (int i = 0; i < grid[0].length; i++){
            if (i > 0){
                pre += grid[1][i - 1];
            }
            sum -= grid[0][i];
            ans = Math.min(ans, Math.max(sum, pre));
        }
        return ans;
    }
}
