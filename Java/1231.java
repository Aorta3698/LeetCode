https://leetcode.com/problems/divide-chocolate/discuss/1658195/Java-Almost-identical-to-410-1011-Just-Binary-Search
class Solution {
    public int maximizeSweetness(int[] nums, int m) {
        m++;

        int lo = Integer.MAX_VALUE, hi = -1, sum = 0, n = nums.length;
        for (int w : nums){
            sum += w;
            lo = Math.min(lo, w);
        }

        hi = sum / m + Integer.signum(sum % m) + 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (isOK(mid, nums, m)) lo = mid + 1;
            else hi = mid;
        }

        return lo - 1;
    }

    private boolean isOK(int guess, int[] arr, int minGroup){
        int group = 0, sum = 0;
        for (int n : arr){
            sum += n;
            if (sum >= guess){
                sum = 0;
                group++;
            }
        }

        return group >= minGroup;
    }
}
