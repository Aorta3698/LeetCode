https://leetcode.com/problems/merge-triplets-to-form-target-triplet/discuss/1974555/Java-or-Check-Max-For-Each-Position-or-0ms
class Solution {
    public boolean mergeTriplets(int[][] T, int[] target) {
        return ok(T, target, 0) && ok(T, target, 1) && ok(T, target, 2);
    }

    private boolean ok(int[][] tri, int[] target, int j){
        for (int[] t : tri){
            if (t[j] == target[j] && t[(j + 1) % 3] <= target[(j + 1) % 3] && t[(j + 2) % 3] <= target[(j + 2) % 3])
                return true;
        }
        return false;
    }
}
