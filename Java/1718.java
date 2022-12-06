class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] ans = new int[2 * n - 1];
        solve(0, ans, new boolean[n + 1]);
        return ans;
    }

    private boolean solve(int i, int[] ans, boolean[] used){
        if (i == ans.length)
            return true;
        if (ans[i] > 0)
            return solve(i + 1, ans, used);

        for (int j = ans.length/2 + 1; j >= 1; j--){
            if (j > 1 && i + j >= ans.length || used[j] || j > 1 && ans[i + j] > 0)
                continue;

            ans[i] = j;
            if (j > 1){
                ans[i + j] = j;
            }
            used[j] = true;
            if (solve(i + 1, ans, used))
                return true;

            used[j] = false;
            ans[i] = 0;
            if (j > 1){
                ans[i + j] = 0;
            }
        }

        return false;
    }
}
