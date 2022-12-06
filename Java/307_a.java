class Solution {
    public int minNumberOfHours(int a, int b, int[] energy, int[] experience) {
        int ans = 0;
        for (int i = 0; i < energy.length; i++){
            a -= energy[i];
        }
        int lo = 0, hi = 10000;
        while(lo < hi){
            int mid = (lo+hi) >> 1;
            int got = mid+b;
            boolean ok = true;
            for (int e : experience){
                ok &= e < got;
                got += e;
            }
            if (ok){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo + Math.max(0, -a+1);
    }
}
