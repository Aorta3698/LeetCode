class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ans = 0;
        for (int i = 0; i < nums1.length; i++){
            int j = nums1.length - 1 - i;
            ans += nums1[i] * nums2[j];
        }
        return ans;
    }
}
