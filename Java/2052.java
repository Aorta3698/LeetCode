class Solution {
    public int minimumCost(String sentence, int k) {
        String[] words = sentence.split(" ");
        int n = words.length, score = 0, count = 0, ans = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n ; i++){
            dp[i] = Integer.MAX_VALUE;
            int sum = 0;
            for (int j = i; j > 0; j--){
                sum += (j == i? words[j - 1].length() : words[j - 1].length() + 1);
                if (sum > k)
                    break;
                if (i == n){
                    ans = Math.min(dp[j - 1], ans);
                }
                dp[i] = Math.min(dp[i], dp[j - 1] + (int)Math.pow(k - sum, 2));
            }
        }

        return ans;
    }
}
