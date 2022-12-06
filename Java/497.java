class Solution {

    Random random;
    int[][] rects;
    long[] pre;
    public Solution(int[][] rects) {
        random = new Random();
        this.rects = rects;
        pre = new long[rects.length];

        int i = 0;
        long areas = 0;
        for (int[] r : rects){
            areas += (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
            pre[i++] = areas;
        }
    }
    
    public int[] pick() {
        long p = random.nextLong(pre[pre.length - 1]);

        int lo = 0, hi = pre.length - 1;
        while(lo < hi){
            int mid = (lo + hi) >> 1;
            if (pre[mid] > p){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        if (lo > 0){
            p -= pre[lo - 1];
        }

        int x = rects[lo][0], y = rects[lo][1];
        int sz = rects[lo][2] - x + 1;

        return new int[]{x + (int)(p % sz), y + (int)(p / sz)};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
