class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int ans = 0;
        for (int i = 0; i < nums1.length; i++){
            int lo = -1, hi = nums2.length - 1;
            while(lo < hi){
                int mid = (lo + hi+ 1) >> 1;
                if (nums2[mid] >= nums1[i]) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            ans = Math.max(ans, lo - i);
        }

        return ans;
    }
}
