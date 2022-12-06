https://leetcode.com/problems/score-after-flipping-matrix/discuss/1631236/Java-or-Just-10-Lines-or-100-andand-100-or-Explanations!
class Solution {
    public int matrixScore(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int ans = N;
        for (int i = 1; i < M; i++){
            int count = 0;
            for (int j = 0; j < N; j++)
                if (grid[j][i] == 1 - grid[j][0])
                    count++;
            ans <<= 1;
            ans += Math.max(count, N - count);
        }

        return ans;
    }
}
