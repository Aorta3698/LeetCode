https://leetcode.com/problems/spiral-matrix-iii/discuss/1633888/Java-or-12-Lines-Made-Easy-or-Comments
class Solution {
    public int[][] spiralMatrixIII(int N, int M, int r, int c) {
        int[][] ans = new int[N * M][2];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int idx = 0;
        int count = 2;
        while(idx < ans.length){
            for (int i = 0; i < count/2; i++){
                if (r >= 0 && r < N && c >= 0 && c < M)
                    ans[idx++] = new int[]{r, c};
                int d = (count + 2) % 4;
                r += dirs[d][0];
                c += dirs[d][1];
            }
            count++;
        }

        return ans;
    }
}
