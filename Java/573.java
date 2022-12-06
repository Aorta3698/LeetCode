class Solution {
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int dist = 0, max = Integer.MIN_VALUE;
        for (int[] n : nuts){
            int m = d(n, tree);
            dist += m * 2;
            max = Math.max(m - d(squirrel, n), max);
        }
        return dist - max;
    }

    private int d(int[] a, int[] b){
        int x = a[0] - b[0];
        int y = a[1] - b[1];
        return Math.abs(x) + Math.abs(y);
    }
}
