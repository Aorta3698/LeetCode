class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, st = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]-nums[st]>k){
                st=i;
                ans++;
            }
        }
        return ans+1;
    }
}
