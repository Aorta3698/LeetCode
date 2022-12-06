class Solution {
    public int binarySearchableNumbers(int[] nums) {
        int ans = 0, n = nums.length;
        Set<Integer> cand = new HashSet<>();
        for (int i = 0, max = nums[0]; i < n; max = Math.max(nums[i++], max))
            if (nums[i] >= max)
                cand.add(i);

        for (int i = n - 1, min = nums[n - 1]; i >= 0; min = Math.min(nums[i--], min))
            if (nums[i] <= min && cand.contains(i))
                ans++;

        return ans;
    }
}
