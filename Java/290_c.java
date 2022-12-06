
class Solution {
    public int[] countRectangles(int[][] R, int[][] P) {
        int[] ans = new int[P.length];
        List<Integer>[] rect = new ArrayList[101];
        Arrays.setAll(rect, o -> new ArrayList<>());
        for (int[] r : R){
            rect[r[1]].add(r[0]);
        }
        for (List<Integer> r : rect){
            Collections.sort(r);
        }
        for (int j = 0; j < P.length; j++){
            for (int i = P[j][1]; i <= 100; i++){
                List<Integer> cur = rect[i];
                int lo = 0, hi = cur.size();
                while(lo < hi){
                    int mid = (lo + hi) >> 1;
                    if (cur.get(mid) >= P[j][0]){
                        hi = mid;
                    }else{
                        lo = mid + 1;
                    }
                }
                ans[j] += cur.size() - lo;
            }
        }

        return ans;
    }
}
