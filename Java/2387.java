class Solution {
    public int matrixMedian(int[][] grid) {
        int lo = 1, hi = 1000000, m = grid.length, n = grid[0].length;
        while(lo < hi){
            int mid = (lo+hi+1)>>1, count = 0;
            for (int[] g : grid){
                int low = 0, high = n;
                while(low < high){
                    int middle = (low+high)>>1;
                    if (g[middle] >= mid){
                        high = middle;
                    }else{
                        low = middle+1;
                    }
                }
                count += n-low;
            }
            if (count > m*n/2){
                lo=mid;
            }else{
                hi=mid-1;
            }
        }
        return lo;
    }
}
