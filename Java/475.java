class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int lo = 0, hi = (int)1e9;

        while(lo < hi){
            int mid = (lo + hi) >> 1;
            int j;

            for (j = 0; j < houses.length; j++){
                int low = 0, high = heaters.length;
                while(low < high){ // find the smallest that's >= houses[j] - mid, high = len -> not found.
                    int m = (low + high) >> 1;
                    if (heaters[m] >= houses[j] - mid) high = m;
                    else low = m + 1;
                }
                int lowest = low;
                low = -1; high = heaters.length - 1;
                while(low < high){ // find the biggest that's <= houses[j] + mid, low == -1 -> not found.
                    int m = (low + high + 1) >> 1;
                    if (heaters[m] <= houses[j] + mid) low = m;
                    else high = m - 1;
                }
                if (lowest > low){
                    break;
                }
            }

            if (j == houses.length) {
                hi = mid;
            }else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
