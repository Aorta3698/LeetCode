class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0, ans = nums.length, pre = 0;
        for (int n : nums){
            sum = (sum + n) % p;
        }

        if (sum == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        for (int i = 0; i < nums.length; i++){
            pre = (pre + nums[i]) % p;
            ans = Math.min(ans, i - map.getOrDefault(((pre - sum) % p + p) % p, -nums.length));
            map.put(pre, i);
        }

        return ans == nums.length? -1 : ans;
    }
}
