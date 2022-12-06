class Solution {
    public int totalFruit(int[] fruits) {
        int ans = 0, n = fruits.length;
        int[] cnt = new int[n];
        for (int i = 0, uni = 0; i < n; i++){
            if (++cnt[fruits[i]] == 1) uni++;
            if (uni <= 2) ans++;
            else if (--cnt[fruits[i - ans]] == 0) uni--;
        }

        return ans;
    }
}
