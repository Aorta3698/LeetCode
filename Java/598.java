class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minR = Integer.MAX_VALUE, minC = minR;
        for (int[] o : ops){
            minR = Math.min(o[0], minR);
            minC = Math.min(o[1], minC);
        }

        return minC == Integer.MAX_VALUE? m * n : minC * minR;
    }
}
