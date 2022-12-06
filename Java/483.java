class Solution {
    public String smallestGoodBase(String n) {
        long v = Long.valueOf(n);
        for (int i = 60; i >= 2; i--){
            long lo = 2, hi = (long)1e18;
            while(lo < hi){
                long mid = (lo+hi)>>1;
                long res = cal(mid, i);
                if (res == -1 || res >= v){
                    hi=mid;
                }else{
                    lo=mid+1;
                }
            }
            long res = cal(lo, i);
            if (res != -1 && res == v){
                return ""+lo;
            }
        }
        return ""+(v-1);
    }

    private long cal(long x, int n){
        long ans = 0;
        long cur = 1;
        while(n-- >= 0){
            if (Long.MAX_VALUE - cur < ans){
                return -1;
            }
            ans += cur;
            if (n >= 0 && Long.MAX_VALUE/x < cur){
                return -1;
            }
            cur *= x;
        }
        return ans;
    }
}
