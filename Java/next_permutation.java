class Solution {
    public void nextPermutation(int[] nums) {
        //1. Find the largest index k such that a[k] < a[k + 1].
        //If no such index exists, the permutation is the last permutation.

        //2. Find the largest index l greater than k such that a[k] < a[l].
        //3. Swap the value of a[k] with that of a[l].
        //4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
        int end = nums.length-1;

        int n = end-1;
        while(n >= 0 && nums[n+1] <= nums[n])
            n--;

        if (n < 0) {
            reverse(nums, 0, end);
            return;
        }

        for (int i = end; i > n; i--){
            if (nums[i] > nums[n]){
                swap(nums, i, n);
                reverse(nums, n+1, end);
                return;
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(int[] arr, int start, int end){
        while(start < end)
            swap(arr, start++, end--);
    }
}
