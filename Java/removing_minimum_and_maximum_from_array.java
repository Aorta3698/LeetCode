class Solution {
    public int minimumDeletions(int[] nums) {
        int maxIdx = 0;
        int minIdx = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[maxIdx]) maxIdx = i;
            if (nums[i] < nums[minIdx]) minIdx = i;
        }

        int len = nums.length;
        int l = Math.max(maxIdx, minIdx) + 1;
        int r = Math.max(len - maxIdx, len - minIdx);
        int m = maxIdx > minIdx? minIdx + 1 + len - maxIdx : maxIdx + 1 + len - minIdx;

        return Math.min(Math.min(l, r), m);
    }
}
