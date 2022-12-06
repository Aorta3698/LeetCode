class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] nums = new int[n + m];
        int i = 0, j = 0, idx = 0;
        while(i < n || j < m){
            if (i < n && j < m){
                nums[idx] = Math.min(nums1[i], nums2[j]);
                if (nums[idx++] == nums1[i]) i++;
                else j++;
                continue;
            }
            if (i == n) nums[idx++] = nums2[j++];
            else nums[idx++] = nums1[i++];
        }

        int o = nums.length;
        return o % 2 == 1? nums[o / 2] : (double)(nums[o / 2] + nums[o / 2 - 1]) / 2;
    }
}
