class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] arr = new int[n][2];
        for (int i = 0 ; i< n; i++){
            arr[i] = new int[]{profits[i], capital[i]};
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        var maxheap = new PriorityQueue<Integer>();
        for (int i = 0; k > 0; k--){
            while(i < n && arr[i][1] <= w){
                maxheap.offer(-arr[i++][0]);
            }
            if (!maxheap.isEmpty()){
                w -= maxheap.poll();
            }
        }
        return w;
    }
}
