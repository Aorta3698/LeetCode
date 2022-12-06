class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++){
            List<Integer> tri = triangle.get(i);
            for (int j = tri.size() - 1; j >= 0; j--){
                dp[j] = Math.min(dp[Math.min(j, tri.size() - 2)], dp[Math.max(0, j - 1)]) + tri.get(j);
            }
        }

        return Arrays.stream(dp).min().getAsInt();
    }
}
