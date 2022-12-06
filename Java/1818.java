https://leetcode.com/problems/minimum-absolute-sum-difference/discuss/1886382/Java-or-Sort-and-Binary-Search-for-closest-or-95-speed
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] arr = nums1.clone();
        Arrays.sort(arr);

        long ans = 0;
        int m = (int)1e9+7, n = nums1.length, save = 0;
        for (int i = 0; i < n; i++){
            int d = Math.abs(nums2[i] - nums1[i]);
            int lo = 0, hi = n - 1;
            while(lo < hi){
                int mid = (lo + hi + 1) >> 1;
                if (arr[mid] < nums2[i]){
                    lo = mid;
                }else{
                    hi = mid - 1;
                }
            }
            int x = Math.abs(nums2[i] - arr[lo]);
            int y = Math.abs(nums2[i] - arr[Math.min(n - 1, lo + 1)]);
            save = Math.max(save, d - x);
            save = Math.max(save, d - y);
            ans += d;
        }

        return (int)((ans - save) % m);
    }
}
