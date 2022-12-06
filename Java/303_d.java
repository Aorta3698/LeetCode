class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        nums = Arrays.stream(nums).distinct().toArray();
        long ans = 0;
        long[] count = new long[61];
        int[] bit = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            bit[i] = Integer.bitCount(nums[i]);
            count[bit[i]]++;
        }
        for (int i = 59; i >= 0; i--){
            count[i] += count[i+1];
        }
        for (int i = 0; i < nums.length; i++){
            ans += bit[i] >= k? nums.length : count[k - bit[i]];
        }
        return ans;
    }
}
