https://leetcode.com/problems/number-of-ways-to-build-sturdy-brick-wall/discuss/1910127/Java-Short-DP
class Solution {
    public int buildWall(int height, int width, int[] bricks) {
        return solve(height, width, bricks, new Integer[height + 1][1 << width], 0, 0, 0);
    }

    private int solve(int h, int w, int[] brick, Integer[][] dp, int config, int curWidth, int prev){
        if (dp[h][prev] != null){
            return dp[h][prev];
        }
        if (h == 0){
            return 1;
        }
        if (curWidth == w){
            return solve(h - 1, w, brick, dp, 0, 0, config);
        }

        int ans = 0;
        for (int b : brick){
            int sz = curWidth + b, nc = sz < w? config | (1 << sz) : config;
            if (sz > w || (nc & prev) > 0){
                continue;
            }
            ans = (ans + solve(h, w, brick, dp, nc, sz, prev)) % 1000000007;
        }

        return config == 0? dp[h][prev] = ans : ans;
    }
}
