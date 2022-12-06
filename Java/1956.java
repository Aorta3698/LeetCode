class Solution {
    public int minDayskVariants(int[][] points, int k) {
        int lo = 0, hi = 1000, m = points.length, n = points[0].length;
        while(lo < hi){
            int mid = (lo+hi)>>1;
            boolean ok = false;
            for (int i = -50; i < 150 && !ok; i++){
                for (int j = -50; j < 150 && !ok; j++){
                    int count = 0;
                    for (int[] p : points){
                        if (Math.abs(p[0] - i) + Math.abs(p[1] - j) <= mid){
                            count++;
                        }
                    }
                    ok |= count >= k;
                }
            }
            if (ok){
                hi=mid;
            }else{
                lo=mid+1;
            }
        }
        return lo;
    }
}
