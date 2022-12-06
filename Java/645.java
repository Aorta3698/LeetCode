class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2];
        int[] count = new int[n + 1];
        int sum = 0;
        for (int o : nums){
            if (++count[o] == 2)
                ans[0] = o;
            sum += o;
        }

        ans[1] = ((1 + n) * n) / 2 - (sum - ans[0]);
        return ans;
    }
}
