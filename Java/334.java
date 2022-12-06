class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] lo = new int[nums.length];
        int[] hi = new int[nums.length];
        Arrays.fill(hi, Integer.MIN_VALUE);
        Arrays.fill(lo, Integer.MAX_VALUE);
        for (int i = 0; i < nums.length; i++){
            int j = nums.length - 1 - i;
            lo[i] = Math.min(nums[i], lo[i == 0? 0 : i - 1]);
            hi[j] = Math.max(nums[j], hi[i == 0? 0 : j + 1]);
        }
        for (int i = 1; i < nums.length - 1; i++){
            if (hi[i + 1] > nums[i] && nums[i] > lo[i - 1])
                return true;
        }
        return false;
    }
}
