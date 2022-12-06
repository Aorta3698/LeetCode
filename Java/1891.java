https://leetcode.com/problems/cutting-ribbons/discuss/1658977/Java-Binary-Search-Similar-to-1011-410-1231-With-Comments
class Solution {
    public int maxLength(int[] ribbons, int k) {
        int lo = 0, hi = (int)1e5;

        while(lo < hi){
            int mid = 1 + lo + (hi - lo) / 2;
            if (ok(mid, ribbons, k)) lo = mid;
            else hi = mid - 1;
        }

        return lo;
    }

    private boolean ok(int guess, int[] arr, int minCut){
        int cut = 0;
        for (int n : arr)
            cut += n / guess;
        return cut >= minCut;
    }
}
