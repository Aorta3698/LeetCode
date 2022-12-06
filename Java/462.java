https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/discuss/2215696/Find-Median-Java
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0, j = nums.length-1; i < j; i++,j--){
            ans+=nums[j]-nums[i];
        }
        return ans;
    }
}

class Solution {
    public int minMoves2(int[] nums) {
        int lo = (int)-1e9, hi = -lo;
        while(lo < hi){
            int o = hi <= 0? -1 : 0;
            int mid = (lo + hi + o) / 2;
            if (get(nums, mid + 1) >= get(nums, mid)){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return (int)(get(nums, lo));
    }

    private long get(int[] nums, int t){
        long sum = 0;
        for (int n : nums){
            sum += Math.abs(n - t);
        }
        return sum;
    }
}
