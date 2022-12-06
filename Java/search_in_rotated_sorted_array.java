class Solution {
    public int search(int[] nums, int target) {
        int hi = nums.length - 1;
        int lo = 0;
        boolean isRotated = false;
        int rotateEnd = 0;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[hi] < nums[lo]){
                isRotated = true;
            }

            if (isRotated){
                if (nums[lo] < nums[mid]) lo = mid;
                if (nums[hi] > nums[mid]) hi = mid;
                if (nums[mid] > nums[mid + 1]) {
                    rotateEnd = mid;
                    break;
                }
                if (nums[mid] < nums[mid - 1]){
                    rotateEnd = mid - 1;
                    break;
                }
            }

            if (!isRotated){
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) hi = mid - 1;
                if (nums[mid] < target) lo = mid + 1;
            }
        }

        if (isRotated){
            int a = binarySearch(nums, 0, rotateEnd, target);
            if (a != -1) return a;
            int b = binarySearch(nums, rotateEnd + 1, nums.length - 1, target);
            if (b != -1) return b;
        }

        return -1;
    }

    private int binarySearch(int[] nums, int lo, int hi, int target){
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) hi = mid - 1;
            if (nums[mid] < target) lo = mid + 1;
        }

        return -1;
    }
}
