class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        for (int[] row : mat){
			// FIND THE FIRST 0. UPPER BOUND IS THE WHOLE LENGTH, INDICATING NO 0 WAS FOUND.
            int lo = 0, hi = row.length;
            while(lo < hi){
                int mid = (lo + hi) >> 1;
                if (row[mid] == 0){
                    hi = mid;
                }else{
                    lo = mid + 1;
                }
            }
            minheap.offer(new int[]{lo, minheap.size()});
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = minheap.poll()[1];
        }

        return ans;
    }
}
