class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = profit.length, m = worker.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++){
            data[i][0] = difficulty[i];
            data[i][1] = profit[i];
        }
        Arrays.sort(data, Comparator.comparingInt(o -> o[0]));

        int k = (int)(Math.log(n) / Math.log(2)); // num of range
        int[][] table = new int[n][k + 1];
        for (int i = 0; i < n; i++){
            table[i][0] = data[i][1];
        }
        for (int i = 1; i <= k; i++){
            for (int j = 0; j + (1 << i) - 1 < n; j++){
                table[j][i] = Math.max(table[j][i - 1], table[j + (1 << (i - 1))][i - 1]);
            }
        }
        int[] log = new int[n + 1];
        for (int i = 2; i <= n; i++){
            log[i] = log[i >> 1] + 1;
        }

        int ans = 0;
        for (int w : worker){
            int lo = -1, hi = n - 1;
            while(lo < hi){
                int mid = (lo + hi + 1) >> 1;
                if (data[mid][0] <= w) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
            }
            if (lo >= 0){
                int r = log[lo + 1];
                ans += Math.max(table[0][r], table[lo - (1 << r) + 1][r]);
            }
        }
        // Arrays.sort(worker);
        // for (int i = 0, j = -1; i < m; i++){
        //     while(j < n - 1 && worker[i] >= data[j + 1][0]){
        //         ++j;
        //     }
        //     int r = log[j + 1];
        //     ans += (j == -1? 0 : Math.max(table[0][r], table[j - (1 << r) + 1][r]));
        // }

        return ans;
    }
}
