https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/1886554/Java-or-Almost-Identical-to-33.
class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(hi > lo && nums[hi] == nums[0]){
            --hi;
        }
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            int m = 0;
            if ((nums[mid] < nums[0]) == (target < nums[0])){
                m = nums[mid];
            }else{
                m = target < nums[0]? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (m == target){
                return true;
            }else if (m > target){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }

        return false;
    }
}

// class Solution {
//     public boolean search(int[] nums, int target) {
//         int lo = 0, hi = nums.length - 1;
//         while(lo <= hi && nums[lo] == nums[hi]){
//             ++lo;
//         }
//         while(hi >= lo && nums[hi] == nums[0]){
//             --hi;
//         }
//         if (nums[0] == target){
//             return true;
//         }

//         while(lo <= hi){
//             int mid = (lo + hi) >> 1;
//             if (target == nums[mid]){
//                 return true;
//             }
//             if (nums[mid] < nums[lo]){
//                 // if (target < nums[hi] && target > nums[mid]){
//                 //     lo = mid + 1;
//                 // }else{
//                 //     hi = mid - 1;
//                 // }
//                 if (target < nums[mid] || target >= nums[lo]){
//                     hi = mid - 1;
//                 }else{
//                     lo = mid + 1;
//                 }
//             }else{
//                 // if (target > nums[lo] && target < nums[mid]){
//                 //     hi = mid - 1;
//                 // }else{
//                 //     lo = mid + 1;
//                 // }
//                 if (target > nums[mid] || target < nums[lo]){
//                     lo = mid + 1;
//                 }else{
//                     hi = mid - 1;
//                 }
//             }
//         }

//         return false;
//     }
// }
