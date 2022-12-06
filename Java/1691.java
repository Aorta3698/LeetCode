https://leetcode.com/problems/maximum-height-by-stacking-cuboids/discuss/2297881/Java-or-Comparator-Chaining-is-so-slow
class Solution {
    public int maxHeight(int[][] cub) {
        for (int[] c : cub){
            Arrays.sort(c);
        }
        var cmp = Comparator.<int[]>comparingInt(o -> -o[2])
                            .thenComparingInt(o -> -o[1])
                            .thenComparingInt(o -> -o[0]);
        Arrays.sort(cub, cmp);
        int n = cub.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            for (int j = i; j >= 0; j--){
                if (cub[j][0]>=cub[i][0]&&cub[j][1]>=cub[i][1]&&cub[j][2]>=cub[i][2]){
                    dp[i]=Math.max(dp[i], dp[j]+cub[i][2]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    // 95 53 37
    // 50 45 20
    // 45 23 12
}
