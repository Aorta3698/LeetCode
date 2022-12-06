https://leetcode.com/problems/maximum-building-height/discuss/2361890/Java-or-Trim-Backward-then-Count-Forward
class Solution {
    public int maxBuilding(int n, int[][] R) {
        Arrays.sort(R, Comparator.comparingInt(o -> -o[0]));
        int cur = (int)2e9, pre = -1, ans = 0, x = 1, y = 0;
        for (int[] r : R){
            cur = Math.min(r[1], pre-r[0]+cur);
            r[1] = cur;
            pre = r[0];
        }
        for (int i = R.length-1; true; i--){
            // a + b = r[0] - x;
            // a - b = r[1] - y;
            // y + a = ;
            int[] r = i == -1? new int[]{n, n-1} : R[i];
            int res = Math.min((r[0]+r[1]-(x+y))/2+y, y+r[0]-x);
            ans = Math.max(ans, res);
            x = r[0];
            y = Math.min(res, r[1]);
            if (i == -1){
                return ans;
            }
        }
    }
}
