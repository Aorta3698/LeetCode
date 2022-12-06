https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/2182244/Java-or-2ms-or-Iterative-QuickSelect
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, k);
    }

    private int quickSelect(int[] nums, int k){
        int lo = 0, hi = nums.length-1;
        while(lo<=hi){
            int pidx = partition(nums, lo, hi);
            if (pidx+1>=k){
                hi=pidx-1;
            }else{
                lo=pidx+1;
            }
        }
        return nums[lo];
    }

    private int partition(int[] nums, int lo, int hi){
        Random random = new Random();
        int pivot = random.nextInt(hi-lo+1)+lo;
        int cur = lo;
        for (int i = lo; i <= hi; i++){
            if (nums[i]>nums[pivot]){
                swap(i, cur, nums);
                if (cur++==pivot){
                    pivot=i;
                }
            }
        }
        swap(cur, pivot, nums);
        return cur;
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}
