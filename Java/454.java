class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> oneMap = new HashMap<>(), twoMap = new HashMap<>();
        int ans = 0;
        for (int n : nums1)
            for (int m : nums2)
                oneMap.merge(n + m, 1, Integer::sum);
        for (int n : nums3)
            for (int m : nums4)
                twoMap.merge(n + m, 1, Integer::sum);
        for (int key : oneMap.keySet())
            ans += oneMap.get(key) * twoMap.getOrDefault(-key, 0);

        return ans;
    }
}
