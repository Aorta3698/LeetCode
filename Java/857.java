class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = wage.length;
        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++){
            arr[i] = new double[]{quality[i], 1.*wage[i]/quality[i]};
        }
        var maxheap = new PriorityQueue<Integer>(Comparator.comparingDouble(o -> -arr[o][0]));
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[1]));
        int q = 0;
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < n; i++){
            maxheap.offer(i);
            q += arr[i][0];
            if (i >= k){
                q -= arr[maxheap.poll()][0];
            }
            if (i >= k-1){
                ans = Math.min(ans, q * arr[i][1]);
            }
        }
        return ans;
    }
}
