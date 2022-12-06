class Solution {
    int best = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        find(workers, bikes, 0, 0, new boolean[bikes.length]);
        return best;
    }

    private void find(int[][] w, int[][] b, int idx, int score, boolean[] taken){
        if (idx == w.length || score >= best){
            best = Math.min(best, score);
            return;
        }

        for (int i = 0; i < b.length; i++){
            if (taken[i]) continue;
            taken[i] = true;
            find(w, b, idx + 1, score + dist(w[idx], b[i]), taken);
            taken[i] = false;
        }
    }

    private int dist(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
