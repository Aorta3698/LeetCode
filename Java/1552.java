class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1, hi = (int)1e9;

        while(lo < hi){
            int mid = (hi + lo + 1) >> 1;
            int i, prev = (int)-1e9, sum = 0;
            for (i = 0; i < position.length && sum < m; i++){
                if (position[i] - prev >= mid){
                    sum++;
                    prev = position[i];
                }
            }
            if (sum == m) lo = mid;
            else hi = mid - 1;
        }

        return lo;
    }
}
