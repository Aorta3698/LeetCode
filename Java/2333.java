https://leetcode.com/problems/minimum-sum-of-squared-difference/discuss/2260781/Java-or-Binary-Search
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int lo=0,hi=100000;
        long used=0,ans=0;
        while(lo<hi){
            int mid=(lo+hi)>>1;
            long need=0;
            for (int i = 0 ; i< nums1.length;i++){
                need += Math.max(0, Math.abs(nums1[i]-nums2[i])-mid);
            }
            if (need<=k1+k2){
                hi=mid;
                used=need;
            }else{
                lo=mid+1;
            }
        }

        long extra=k1+k2-used;
        for (int i = 0; i< nums1.length;i++){
            long diff = (long)Math.min(lo, Math.abs(nums1[i]-nums2[i]));
            if (diff==lo&&extra>0&&diff>0){
                --diff;
                --extra;
            }
            ans+=diff*diff;
        }

        return ans;
    }
}
