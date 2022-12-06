class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 0, max = 0, cur = 0;
        for (int d : differences){
            cur += d;
            min = Math.min(cur, min);
            max = Math.max(cur, max);
        }
        if (max - min < 0) return 0;
        return Math.max(0, (upper - lower) - (max - min) + 1);
    }
}
