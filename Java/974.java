class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        int pre = 0, ans = 0;
        for (int n : nums){
            pre = ((pre + n) % k + k) % k;
            ans += map.getOrDefault(pre, 0);
            map.merge(pre, 1, Integer::sum);
        }
        // for (int key : map.keySet()){
        //     int count = map.get(key);
        //     ans += (count * (count - 1) / 2);
        // }

        return ans;
    }
}
