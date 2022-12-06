https://leetcode.com/problems/minimum-number-of-lines-to-cover-points/discuss/1808953/java-dp-bitmask-comments
class Solution {
    public int minimumLines(int[][] points) {
        int n = points.length, ttl = (1 << n) - 1;
        int[] dp = new int[ttl + 1];
        Arrays.fill(dp, ttl);

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int cur = (1 << i) + (1 << j);
                int dx = points[i][0] - points[j][0];
                int dy = points[i][1] - points[j][1];
                for (int w = j + 1; w < n; w++){
                    int ddx = points[i][0] - points[w][0];
                    int ddy = points[i][1] - points[w][1];
                    if (dx * ddy == dy * ddx){
                        cur |= 1 << w;
                    }
                }
                for (int s = cur; s > 0; s = (s - 1) & cur){
                    dp[s] = 1;
                }
            }
        }

        for (int i = 0; i <= ttl; i++){
            if (dp[i] == ttl){
                for (int j = i & (i - 1); j > 0; j = (j - 1) & i){
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }

        return dp[ttl];
    }
}
