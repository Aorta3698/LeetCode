class Solution {
    public boolean isMonotonic(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);
        if (Arrays.equals(copy, nums)) return true;
        int lo = 0, hi = copy.length - 1;
        while(lo < hi){
            int tmp = copy[lo];
            copy[lo] = copy[hi];
            copy[hi] = tmp;
            lo++; hi--;
        }

        return Arrays.equals(copy, nums);
    }
}
