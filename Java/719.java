https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/1676700/Java-or-Two-Solution-or-Binary-Search-OR-Sliding-Window
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length - 1] - nums[0];
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (cover(nums, mid, k)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean cover(int[] nums, int guess, int k){
        int cnt = 0;
        for (int i = 0, j = 0; i < nums.length && cnt < k; i++){ //j = left end, i = right end
            while(nums[i] - nums[j] > guess) j++;
            cnt += i - j;
        }
        return cnt >= k;
    }

    //1,1,1,1,1,5,5,5,5,5
    // private boolean cover(int[] nums, int guess, int k){
    //     int cnt = 0, n = nums.length;
    //     for (int i = 0; i < n && cnt < k; i++){
    //         int lo = i, hi = n - 1;
    //         while(lo < hi){
    //             int mid = lo + (hi - lo + 1) / 2;
    //             if (nums[mid] <= nums[i] + guess) lo = mid;
    //             else hi = mid - 1;
    //         }
    //         cnt += lo - i;
    //     }

    //     return cnt >= k;
    // }
}
