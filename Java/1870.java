class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int lo = 1, hi = (int)1e7+1;
        while(lo < hi){
            int mid = (lo + hi) >> 1;

            double time = 0;
            for (int i = 0; i < dist.length; i++){
                if (i < dist.length - 1){
                    time += Math.ceil(1.0 * dist[i] / mid);
                }else{
                    time += 1.0 * dist[i] / mid;
                }
            }

            if (time <= hour){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return lo == (int)1e7+1? -1 : lo;
    }
}
