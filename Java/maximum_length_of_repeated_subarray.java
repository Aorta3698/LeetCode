class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        //store results in dp[i][j], then dp[i][j] = dp[i-1][j-1] + 1 if nums1[i] == nums2[j]

        int ans = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i < nums1.length; i++)
            for (int j = 0; j < nums2.length; j++)
                if (nums1[i] == nums2[j]){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    ans = Math.max(dp[i + 1][j + 1], ans);
                }

        return ans;
    }
}
