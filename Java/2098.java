class Solution {
    public long largestEvenSum(int[] nums, int k) {
        int n = nums.length;
        long ans = -1;

        Arrays.sort(nums);
        List<Long> odd = new ArrayList<>(List.of(0L));
        List<Long> even= new ArrayList<>(List.of(0L));
        for (int i = n - 1; i >= 0; i--){
            if (nums[i] % 2 == 1) odd.add(nums[i] + odd.get(odd.size() - 1));
            if (nums[i] % 2 == 0) even.add(nums[i] + even.get(even.size() - 1));
        }

        for (int i = 0, j = k; i <= k; i+=2, j = k - i){
            if (i >= odd.size()) continue;
            if (j >= even.size()) continue;
            ans = Math.max(odd.get(i) + even.get(j), ans);
        }

        return ans;
    }
}
