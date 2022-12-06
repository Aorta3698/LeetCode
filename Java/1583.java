https://leetcode.com/problems/count-unhappy-friends/discuss/1877380/Java-Concise-BruteForce-O(N2)
class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] rank = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n - 1; j++){
                rank[i][preferences[i][j]] = j;
            }
        }

        BitSet bit = new BitSet(n);
        for (int i = 0; i < n / 2; i++){
            for (int j = 0; j < n / 2; j++){
                for (int k = 0; k < 2 && i != j; k++){
                    for (int w = 0; w < 2; w++){
                        int xy = rank[pairs[i][k]][pairs[i][1 - k]];
                        int xu = rank[pairs[i][k]][pairs[j][w]];
                        int uv = rank[pairs[j][w]][pairs[j][1 - w]];
                        int ux = rank[pairs[j][w]][pairs[i][k]];
                        if (xu < xy && ux < uv){
                            bit.set(pairs[i][k]);
                        }
                    }
                }
            }
        }

        return bit.cardinality();
    }
}
