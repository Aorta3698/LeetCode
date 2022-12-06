https://leetcode.com/problems/number-of-equivalent-domino-pairs/discuss/1643791/Java-or-2ms-(100)-or-One-Pass-or-DP-w-ArrHash-or-Just-5-Lines-or-Thinking-Process
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int ans = 0;
        for (int[] d : dominoes)
            if (++count[hash(d)] > 1)
                ans += count[hash(d)] - 1;
        return ans;
    }

    private static int hash(int[] d){
        return 10 * Math.max(d[0], d[1]) + Math.min(d[0], d[1]);
    }
}
