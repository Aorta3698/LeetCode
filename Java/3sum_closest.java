class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int lo = nums[0] + nums[1] + nums[2];
        int hi = nums[len - 1] + nums[len - 2] + nums[len - 3];
        if (lo >= target) return lo;
        if (hi <= target) return hi;

        int minDis = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < len; i++){
            lo = i+1;
            hi = len-1;
            while(hi>lo){
                int sum = nums[lo] + nums[hi] + nums[i];
                int dis = sum - target;
                if (minDis > Math.abs(dis)){
                    minDis = Math.abs(dis);
                    ans = sum;
                }
                if (dis == 0) return target;
                if (dis > 0 || hi == i) hi--;
                if (dis < 0) lo++;
            }
        }

        return ans;
    }
}
