class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++){
            arr[i] = new Item(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.e));

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++){
            int lo = -1, hi = i - 1;
            while(lo < hi){
                int mid = (lo + hi + 1) >> 1;
                if (arr[mid].e <= arr[i - 1].s){
                    lo = mid;
                }else{
                    hi = mid - 1;
                }
            }
            dp[i] = Math.max(dp[i - 1], arr[i - 1].p + dp[lo+1]);
        }

        return dp[n];
    }

    private class Item{
        int s;
        int e;
        int p;
        Item(int s, int e, int p){
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }
}
