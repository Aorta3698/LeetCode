class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        int one = 0;
        int two = 0;
        for (int i = 0; i < n; i++){
            diff[i]=nums1[i]-nums2[i];
            one += nums1[i];
            two += nums2[i];
        }
        int[] arr = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        int diffMin = 0;
        int diffMax = 0;
        for (int d : diff){
            diffMax = Math.max(diffMax + d, d);
            diffMin = Math.min(diffMin + d, d);
            arr[0] = Math.min(arr[0], diffMin);
            arr[1] = Math.max(arr[1], diffMax);
        }
        int ans = Math.max(one, two);
        ans = Math.max(ans, two + arr[1]);
        ans = Math.max(ans, one - arr[0]);
        return ans;
    }
}
