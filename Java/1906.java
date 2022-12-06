class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int[][] count = new int[nums.length + 1][101];
        for (int i = 1; i <= nums.length; i++){
            count[i] = count[i - 1].clone();
            count[i][nums[i - 1]]++;
        }

        for (int i = 0; i < queries.length; i++){
            int lo = queries[i][0], hi = queries[i][1], min = 101, prev = -1000;
            for (int j = 0; j <= 100; j++){
                if (count[hi + 1][j] - count[lo][j] == 0){
                    continue;
                }
                min = Math.min(min, j - prev);
                prev = j;
            }
            ans[i] = min == 101? -1 : min;
        }

        return ans;
    }
}
