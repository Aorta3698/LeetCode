https://leetcode.com/problems/rank-transform-of-an-array/discuss/1639280/Java-or-Array-Only-(No-Map-or-Set)
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Integer[] idx = IntStream.range(0, arr.length).boxed().toArray(Integer[]::new);
        int[] ans = new int[arr.length];
        Arrays.sort(idx, Comparator.comparingInt(o -> arr[o]));
        for (int i = 0, prev = Integer.MAX_VALUE, dup = 0; i < ans.length; prev = arr[idx[i++]]){
            dup = prev == arr[idx[i]]? ++dup : dup;
            ans[idx[i]] = i + 1 - dup;
        }
        return ans;
    }
}
