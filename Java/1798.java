class Solution {
    public int getMaximumConsecutive(int[] coins) {
        int ans = 1;
        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++){
            if (coins[i] > ans)
                break;
            ans += coins[i];
        }
        return ans;
    }
}
