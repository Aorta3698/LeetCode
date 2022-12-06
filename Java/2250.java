https://leetcode.com/problems/count-number-of-rectangles-containing-each-point/discuss/1977002/Java-or-Binary-Search-and-Iterate-100-y-position
class Solution {
    public int[] countRectangles(int[][] R, int[][] P) {
        int[] ans = new int[P.length];
        List<Integer>[] rect = new ArrayList[101];
        Arrays.setAll(rect, o -> new ArrayList<>());
        for (int[] r : R){ // Add points
            rect[r[1]].add(r[0]);
        }
        for (List<Integer> r : rect){ // Sort all
            Collections.sort(r);
        }
        for (int j = 0; j < P.length; j++){ // For each point,
            for (int i = P[j][1]; i <= 100; i++){ // we check all possible y positions
                List<Integer> cur = rect[i];
                int lo = 0, hi = cur.size(); // with a binary search
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
