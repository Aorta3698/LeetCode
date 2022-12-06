class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int r = right.length == 0? n : Arrays.stream(right).min().getAsInt();
        int l = left.length == 0? 0 : Arrays.stream(left).max().getAsInt();
        return Math.max(n - r, l);
    }
}
