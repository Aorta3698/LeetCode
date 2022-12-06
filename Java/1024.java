class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        if (clips[0][0] > 0){
            return -1;
        }

        int n = clips.length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--){
                if (dp[j] == Integer.MAX_VALUE){
                    continue;
                }
                if (clips[j][0] == clips[i][0]){
                    dp[i] = Math.min(dp[i], dp[j]);
                }
                if (clips[j][1] >= clips[i][0] && clips[i][0] > clips[j][0]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++){
            if (clips[i][1] >= time){
                ans = Math.min(ans, dp[i]);
            }
        }

        // System.out.println(Arrays.deepToString(clips));
        // System.out.println(Arrays.toString(dp));

        return ans == Integer.MAX_VALUE? -1 : ans;
    }
}
