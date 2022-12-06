class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = Arrays.stream(nums).filter(o -> o % 2 == 0).sum(), i = 0;
        int[] ans = new int[queries.length];
        for (int[] q : queries){
            int prev = (nums[q[1]] & 1);
            nums[q[1]] += q[0];
            int cur  = (nums[q[1]] & 1);

            if (cur == 0 && prev == 1){
                sum += nums[q[1]];
            }
            if (cur == 1 && prev == 0){
                sum -= (nums[q[1]] - q[0]);
            }
            if (cur == 0 && prev == 0){
                sum += q[0];
            }
            ans[i++] = sum;
        }
        return ans;
    }
}
