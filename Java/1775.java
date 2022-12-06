class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int one = Arrays.stream(nums1).sum();
        int two = Arrays.stream(nums2).sum();
        if (two > one){
            return minOperations(nums2, nums1);
        }
        if (6 * nums2.length < nums1.length){
            return -1;
        }

        int diff = one - two, ans = 0;
        int[] count = new int[6];
        for (int n : nums1){
            count[n - 1]++;
        }
        for (int n : nums2){
            count[6 - n]++;
        }
        for (int i = 5; i >= 1; i--){
            if (diff > i * count[i]){
                diff -= i * count[i];
                ans += count[i];
            }else{
                ans += Math.ceil(1.0 * diff / i);
                break;
            }
        }

        return ans;
    }
}
