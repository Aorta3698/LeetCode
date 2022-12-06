class Solution {
    public boolean isRectangleOverlap(int[] o, int[] t) {
        if (t[0] < o[0]) return isRectangleOverlap(t, o);

        if (o[2] > t[0] && o[3] > t[1] && t[2] > o[0] && t[3] > o[1]) return true;
        if (o[0] == t[0] && o[2] == t[2] && o[3] > t[1] && t[1] > o[1]) return true;
        if (o[0] == t[0] && o[2] == t[2] && t[3] > o[1] && o[3] > t[3]) return true;

        return false;
    }
}
