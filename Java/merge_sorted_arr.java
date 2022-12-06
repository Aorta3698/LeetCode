class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = n+m-1; i >= 0; i--){
            if (n == 0) break;
            else if (m == 0 || nums2[n-1]>=nums1[m-1])
                nums1[i]=nums2[--n];
            else
                nums1[i]=nums1[--m];
        }
    }
}
