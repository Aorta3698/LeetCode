class Solution {
    public boolean nimGame(int[] piles) {
        int ans = 0;
        for (int p : piles) ans ^= p;
        return ans != 0;
    }
}
