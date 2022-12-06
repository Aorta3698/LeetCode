class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Comparator<int[]> cmp = Comparator.comparingInt(o -> o[0]);
        cmp = cmp.thenComparing(o -> o[1]);
        PriorityQueue<int[]> minheap = new PriorityQueue<>(cmp);

        for (int i = 0; i < mat.length; i++){
            int hi = mat[0].length;
            int lo = 0;
            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if (mat[i][mid] == 0) hi = mid;
                else lo = mid + 1;
            }

            minheap.offer(new int[]{lo, i});
        }

        int[] ans = new int[k];
        while(k-- > 0)
            ans[ans.length - 1 - k] = minheap.poll()[1];

        return ans;
    }
}
