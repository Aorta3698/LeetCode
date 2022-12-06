class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length, ans = 0, m = (int)1e9 + 7;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++){
            pre[i] += pre[Math.max(i - 1, 0)] + nums[i];
        }

        for (int i = 0; i < n; i++){
            int lo = i + 1, hi = n - 1; // hi set to n - 1, not n - 2
            while(lo < hi){ // FIND THE FIRST POSITION THE MIDDLE ENDS
                int mid = (lo + hi) >> 1;
                if (pre[mid] - pre[i] >= pre[i]){
                    hi = mid;
                }else{
                    lo = mid + 1;
                }
            }
            if (lo == n - 1){ // CANNOT END AT THE END
                continue;
            }
            int j = lo;

            lo--; // lo set to lo - 1, not lo
            hi = n - 2;
            while(lo < hi){ // FIND THE LAST POSITION THE MIDDLE ENDS
                int mid = (lo + hi + 1) >> 1;
                if (pre[n - 1] - pre[mid] >= pre[mid] - pre[i]){
                    lo = mid;
                }else{
                    hi = mid - 1;
                }
            }

            ans = (ans + lo - j + 1) % m;
        }

        return ans;
    }
}
