class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int min = Integer.MAX_VALUE;
        for (int[] g : ghosts)
            min = Math.min(Math.abs(g[0] - target[0]) + Math.abs(g[1] - target[1]), min);
        return Math.abs(target[0]) + Math.abs(target[1]) < min;
    }
}
