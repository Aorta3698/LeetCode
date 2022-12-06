class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = piles.length / 3;
        int ans = 0;
        for (int i = piles.length - 2; count > 0; count--, i-=2)
            ans += piles[i];

        return ans;
    }
}
