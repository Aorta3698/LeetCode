https://leetcode.com/problems/maximum-alternating-subarray-sum/discuss/1917977/Find-Max-and-Min-Subarray-with-Kadane
class Solution {
    public long maximumAlternatingSubarraySum(int[] nums) {
        long ans = nums[0], one = ans, two = 0;
        for (int i = 1, cur; i < nums.length; i++){
            boolean t = i % 2 == 0;
            cur = t? nums[i] : -nums[i];
            one = t? Math.max(cur, one + cur) : one + cur;
            two = t? two + cur : Math.min(cur, two + cur);
            ans = Math.max(ans, Math.max(one, -two));
        }

        return ans;
    }
    // +, -, +, -, +, -...
    // +, +, -, +, -, +...
}
// class Solution {
//     public long maximumAlternatingSubarraySum(int[] nums) {
//         long ans = Long.MIN_VALUE, one = 0, two = 0;
//         for (int i = 0, cur; i < nums.length; i++){
//             boolean t = i % 2 == 0;
//             cur = t? nums[i] : -nums[i];
//             one = t? Math.max(cur, one + cur) : one + cur;
//             ans = Math.max(ans, one);
//             if (i > 0){
//                 two = t? two + cur : Math.min(cur, two + cur);
//                 ans = Math.max(ans, -two);
//             }
//         }

//         return ans;
//     }
//     // +, +, -, +, -, +...
//     // +, -, +, -, +, -...
// }
