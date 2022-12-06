class Solution {
    public int minIncrementForUnique(int[] nums) {
        int ans = 0, lo = -1;
        int[] count = new int[100001];
        for (int n : nums){
            count[n]++;
        }
        for (int i = 0; i < 100001; i++){
            if (count[i] == 0)
                continue;
            lo = Math.max(lo, i);
            ans += count[i] * (lo - i + lo - i + count[i] - 1) / 2;
            lo += count[i];
        }

        return ans;
    }
}
