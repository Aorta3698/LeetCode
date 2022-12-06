class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) >> 1;
            int m = 0;
            if ((nums[mid] < nums[0]) == (target < nums[0])){
                m = nums[mid];
            }else{
                m = target < nums[0]? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (m == target){
                return mid;
            }else if (m > target){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }

        return -1;
    }
}
