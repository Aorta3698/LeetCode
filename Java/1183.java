https://leetcode.com/problems/maximum-number-of-ones/discuss/2418545/Java-or-Translation
class Solution {
    public int maximumNumberOfOnes(int m, int n, int sl, int maxOnes) {
        int[][] grid = new int[sl][sl];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                grid[i%sl][j%sl]++;
            }
        }
        int[] idx = IntStream.range(0, sl*sl).boxed().sorted(Comparator.comparingInt(o -> -grid[o/sl][o%sl])).mapToInt(o -> o).limit(maxOnes).toArray();
        int ans = 0;
        for (int i : idx){
            ans += grid[i/sl][i%sl];
        }
        return ans;
    }
}
