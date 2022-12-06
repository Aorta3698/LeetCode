class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[0]-o[1]));
        int ans = 0, cur = 0;
        for (int[] t : tasks){
            if (t[1] > cur){
                ans += t[1] - cur;
                cur = t[1];
            }
            cur -= t[0];
        }
        return ans;
        // int lo = 0, hi = (int)1e9;
        // while(lo < hi){
        //     int mid = (lo+hi)>>1, cur = mid;
        //     boolean ok = true;
        //     for (int[] t : tasks){
        //         ok &= cur >= t[1];
        //         cur -= t[0];
        //     }
        //     if (ok){
        //         hi=mid;
        //     }else{
        //         lo=mid+1;
        //     }
        // }
        // return lo;
    }
}
