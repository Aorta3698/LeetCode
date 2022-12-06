class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        int pre = 0;

        for (int i = 0; i < nums.length; i++){
            pre = (pre + nums[i]) % k;
            if (map.containsKey(pre) && i - map.get(pre) > 1){
                return true;
            }
            map.putIfAbsent(pre, i);
        }

        return false;
    }
}
