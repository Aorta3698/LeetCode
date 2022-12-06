https://leetcode.com/problems/minimum-health-to-beat-game/discuss/1909811/Java-or-1-liner
class Solution {
    public long minimumHealth(int[] A, int armor) {
        return Arrays.stream(A).asLongStream().sum() - Math.min(Arrays.stream(A).max().getAsInt(), armor) + 1;
    }
}
