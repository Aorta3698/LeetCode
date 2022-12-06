class Solution {
    public int minPatches(int[] nums, int k) {
        long mx = 0;
        int ans = 0;
        for (int n : nums){
            // [0, prev] + [n, prev+n]

            while(Math.min(n-1,k)-mx>0){
                mx+=mx+1;
                ans++;
            }
            mx+=n;
            if (mx >= k){
                break;
            }
        }
        while(mx < k){
            mx += mx+1;
            ans++;
        }
        return ans;
    }
}
