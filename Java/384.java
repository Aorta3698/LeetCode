https://leetcode.com/problems/shuffle-an-array/discuss/1674367/Java-or-Map-Blacklist-to-Whitelist-or-Similar-to-710.
class Solution {

    private Random random;
    private int[] nums;
    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        Map<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[nums.length];
        int sz = ans.length, n = sz - 1;
        while(sz > 0){
            int idx = random.nextInt(sz);
            int guess = map.containsKey(idx)? map.get(idx) : idx;
            if (map.containsKey(sz - 1)) map.put(idx, map.get(sz - 1));
            else {
                while(map.containsKey(n)) n--;
                map.put(idx, n);
                n--;
            }
            ans[ans.length - sz] = nums[guess];
            sz--;
        }

        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
