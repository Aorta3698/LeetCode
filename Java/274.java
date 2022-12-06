class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length, lo = 0, hi = n;
        while(lo < hi){
            int mid = (hi + lo + 1) >> 1;
            int sum = 0;
            for (int m : citations){
                if (m >= mid){
                    sum++;
                }
            }
            if (sum >= mid) lo = mid;
            else hi = mid - 1;
        }

        return lo;
    }
}
