class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length==0) return 0;
        int count = 0;
        Arrays.sort(nums);
        if (nums[0] >= 0 && nums[0] > target/3) return 0;

        for (int i = 0; i < nums.length-2;i++){
            int lo = i+1;
            int hi = nums.length-1;
            while(hi>lo){
                if(nums[hi]+nums[lo]>=target-nums[i])
                    hi--;
                else if (nums[hi]+nums[lo]<target-nums[i]){
                    count += hi - lo;
                    lo++;
                }
            }
        }

        return count;
    }
}
