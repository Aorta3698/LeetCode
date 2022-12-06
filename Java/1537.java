class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        BitSet a = new BitSet();
        BitSet b = new BitSet();
        for (int n : nums1){
            a.set(n);
        }
        for (int n : nums2){
            b.set(n);
        }
        a.and(b);
        int M = (int)1e9+7, i = 0, j = 0;
        long x = 0, y = 0, ans = 0;
        while(i < nums1.length || j < nums2.length || x > 0 || y > 0){
            if (i==nums1.length||a.get(nums1[i])){
                while(j<nums2.length&&(i==nums1.length||nums2[j]!=nums1[i])){
                    y+=nums2[j++];
                }
                ans += (i<nums1.length?nums1[i]:0) + Math.max(x, y);
                x=y=0;
                i++;j++;
            }else{
                x+=nums1[i++];
            }
        }
        return (int)(ans%M);
    }
}
