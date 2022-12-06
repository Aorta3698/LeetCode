class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] q : queries){
            for (int[] p : points){
                if (distSq(p[0], p[1], q[0], q[1]) <= q[2] * q[2])
                    ans[idx]++;
            }
            idx++;
        }
        return ans;
    }

    private int distSq(int x, int y, int dx, int dy){
        return (x - dx) * (x - dx) + (y - dy) * (y - dy);
    }
}
