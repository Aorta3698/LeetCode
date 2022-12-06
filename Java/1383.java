class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int M = (int)1e9+7;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i]=new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> -o[1]));
        var minheap = new PriorityQueue<Integer>();
        long ans = 0, sum = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i][0];
            minheap.offer(arr[i][0]);
            if (i >= k){
                sum -= minheap.poll();
            }
            ans = Math.max(ans, sum * arr[i][1]);
        }
        return (int)(ans%M);
    }
}
