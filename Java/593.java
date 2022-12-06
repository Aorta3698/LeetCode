class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] all = new int[][]{p1, p2, p3, p4};
        Arrays.sort(all, (a, b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        int[] a = line(all[0], all[3]), b = line(all[1], all[2]);

        return
            sz(all[0], all[1]) == sz(all[0], all[2])
         && sz(all[3], all[1]) == sz(all[3], all[2])
         && sz(all[3], all[1]) == sz(all[0], all[1])
         && sz(all[0], all[3]) == sz(all[1], all[2])
         && sz(all[0], all[1]) > 0
         && a[0] * b[0] + a[1] * b[1] == 0;
    }

    private int sz(int[] a, int[] b){
        return (int)(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }

    private int[] line(int[] a, int[] b){
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }
}
