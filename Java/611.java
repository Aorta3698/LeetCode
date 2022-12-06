class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                int lo = j, hi = nums.length - 1;
                while(lo < hi){
                    int mid = (hi + lo + 1) >> 1;
                    if (nums[i] + nums[j] > nums[mid]) lo = mid;
                    else hi = mid - 1;
                }
                ans += (lo - j);
            }
        }
        return ans;
    }
}
