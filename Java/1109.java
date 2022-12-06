class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int[] line = new int[n + 2];
        for (int[] b : bookings){
            line[b[0] - 1] += b[2];
            line[b[1]] -= b[2];
        }
        for (int i = 0, cur = 0; i < n; i++){
            cur += line[i];
            ans[i] = cur;
        }
        return ans;
    }
}
