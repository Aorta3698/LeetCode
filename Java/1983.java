https://leetcode.com/problems/widest-pair-of-indices-with-equal-range-sum/discuss/1871417/Concise-and-Clean-Java-solution
class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int ans = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        for (int i = 0; i < nums1.length; i++){
            pre += (nums1[i] - nums2[i]);
            map.putIfAbsent(pre, i);
            ans = Math.max(ans, i - map.get(pre));
        }

        return ans;
    }
}
