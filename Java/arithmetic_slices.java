class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int idx = 2;

        while(idx < nums.length){
            if (nums[idx] - nums[idx - 1] != nums[idx - 1] - nums[idx - 2]) {idx++; continue;}
            int count = 0;
            int d  = nums[idx] - nums[idx - 1];
            for (;idx < nums.length; idx++){
                if (nums[idx] - nums[idx - 1] != d) break;
                ans += ++count;
            }
        }

        return ans;
    }
}
