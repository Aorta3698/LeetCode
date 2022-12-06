class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        int[] ind = new int[n + 1], outd = new int[n + 1];
        int ans = 0;
        for (int[] t : trust){
            ++outd[t[0]];
            if (++ind[t[1]] == n - 1){
                if (ans != 0) return -1;
                ans = t[1];
            }
        }

        return outd[ans] != 0 || ans == 0? -1 : ans;
    }
}
