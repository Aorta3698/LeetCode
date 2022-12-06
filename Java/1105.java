https://leetcode.com/problems/filling-bookcase-shelves/discuss/1915360/Java-Bottom-Up-DP-or-Confusing-Problem-Statement-IMO
class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++){
            int max = 0, width = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 1 && width + books[j - 1][0] <= shelfWidth; j--){
                max = Math.max(max, books[j - 1][1]);
                dp[i] = Math.min(dp[i], max + dp[j - 1]);
                width += books[j - 1][0];
            }
        }

        return dp[n];
    }
}
