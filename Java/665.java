https://leetcode.com/problems/non-decreasing-array/discuss/2003490/Java-Concise-Solution-Explained.
class Solution {
    public boolean checkPossibility(int[] nums) {
        int miss = 0;
        for (int i = 0; i < nums.length-1; i++){
            if (nums[i]>nums[i+1]){
                if (++miss == 2)
                    return false;
                if (i == 0 || nums[i-1]<=nums[i+1]){
                    continue;
                }
                nums[i+1]=nums[i];
            }
        }
        return true;
    }
}
// class Solution {
//     public boolean checkPossibility(int[] nums) {
//         int cnt = 0;
//         for (int i = 0; i < nums.length - 1; i++){
//             if (nums[i] > nums[i + 1]){
//                 if (++cnt == 2)
//                     return false;
//                 if (i == 0 || nums[i + 1] >= nums[i - 1]){
//                     nums[i] = nums[i + 1];
//                 }else{
//                     nums[i + 1] = nums[i];
//                 }
//             }
//         }
//         return true;
//     }
// }
