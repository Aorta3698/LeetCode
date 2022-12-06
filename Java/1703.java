class Solution {
    public int minMoves(int[] nums, int k) {
        if (k==1){
            return 0;
        }
        int[] ones = new int[Arrays.stream(nums).sum()];
        for (int i = 0, j = 0; i < nums.length; i++){
            if (nums[i]==1){
                ones[j++]=i;
            }
        }
        int n = ones.length;
        long[] pre = new long[n];
        for (int i = 0; i < n; i++){
            pre[i] = i==0? ones[0] : ones[i] + pre[i-1];
        }
        long ans = (int)1e9;
        for (int i = 0; i < n-k+1; i++){
            int j = i+k-1;
            int median = (i+j)/2;
            long del = pre[median-(k&1)]-(i==0?0:pre[i-1]);
            long add = pre[j]-pre[median];
            ans = Math.min(add-del, ans);
        }
        ans -= k%2==1?1L*(1+k/2)*(k/2):1L*((1+k/2)*k/4+(k/2)*(k/2-1)/2);
            //1+2+..+k/2 * 2
        return (int)ans;
    }
}
