class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Integer[] idx = IntStream.range(0, nums.length).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, (a, b) -> Integer.compare(nums[b], nums[a]));
        Set<Integer> take = new HashSet<>();
        for (int i = 0; i < k; i++) take.add(idx[i]);

        int[] ans = new int[k];
        for (int i = 0; i < nums.length && k > 0; i++)
            if (take.contains(i))
                ans[ans.length - (k--)] = nums[i];

        return ans;
    }
}
