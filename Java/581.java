class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = nums[nums.length - 1], max = nums[0], i = -1, j = 0;
        for (int n = 0, m = nums.length - 1; m >= 0; n++, m--){
            if (max > nums[n]){
                i = n;
            }
            if (min < nums[m]){
                j = m;
            }
            max = Math.max(max, nums[n]);
            min = Math.min(min, nums[m]);
        }

        return i - j + 1;
    }
}
// class Solution {
//     public int findUnsortedSubarray(int[] nums) {
//         int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, i = 0, j = nums.length;
//         for (int k = 1; k < nums.length; k++){
//             if (nums[k] < nums[k - 1] || nums[k] < max){
//                 min = Math.min(min, Math.min(nums[k], nums[k - 1]));
//                 max = Math.max(max, Math.max(nums[k], nums[k - 1]));
//                 j = Math.min(j, k - 1);
//                 i = k;
//             }
//             while(j >= 0 && j < nums.length && nums[j] > min){
//                 min = Math.min(min, nums[j]);
//                 max = Math.max(max, nums[j]);
//                 --j;
//             }
//         }

//         return j == nums.length? 0 : i - j;
//     }
// }
