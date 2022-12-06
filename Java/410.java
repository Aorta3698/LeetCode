class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = 0, hi = (int)1e9;
        while (lo < hi){
            int mid = (lo + hi) >> 1;
            int count = 1, sum = 0;
            for (int n : nums){
                if (n > mid){
                    count = (int)1e9;
                    break;
                }
                if (sum + n > mid){
                    sum = 0;
                    count++;
                }
                sum += n;
            }

            if (count <= m){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return lo;
    }
}


class Solution {
    public int splitArray(int[] nums, int m) {
        int lo = -1, hi = -1, sum = 0;
        for (int w : nums){
            sum += w;
            lo = Math.max(lo, w);
        }

        hi = lo * (nums.length / m + Integer.signum(nums.length % m));
        lo = Math.max(lo, sum / m);
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if (isOK(mid, nums, m)) hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }

    private boolean isOK(int c, int[] arr, int d){
        int sum = 0;
        for (int n : arr){
            if (sum + n > c){
                sum = 0;
                d--;
            }
            sum += n;
        }

        return d > 0;
    }
}
