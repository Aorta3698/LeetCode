class Solution {
    public int numTeams(int[] rating) {
        //let dp[i] be the number of number that is smaller than rating[i];
        
        int ans = 0;
        int[] dp = new int[rating.length];
        for (int i = 1; i < rating.length; i++)
            for (int j = i - 1; j >=0; j--)
                if (rating[i] > rating[j]){
                    dp[i]++;
                    ans += dp[j];
                }

        dp = new int[rating.length];
        for (int i = 1; i < rating.length; i++)
            for (int j = i - 1; j >=0; j--)
                if (rating[i] < rating[j]){
                    dp[i]++;
                    ans += dp[j];
                }

        return ans;
    }
}
