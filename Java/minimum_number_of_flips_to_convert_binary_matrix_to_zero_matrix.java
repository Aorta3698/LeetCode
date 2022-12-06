class Solution {
    private static int N;
    private static int M;

    public int minFlips(int[][] mat) {
        N = mat.length;
        M = mat[0].length;
        int state = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                state = (state << 1) | mat[i][j];

        boolean[] seen = new boolean[1 << 9];
        seen[state] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(state);
        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(--size >= 0){
                int cur = queue.poll();
                if (cur == 0) return step;

                for (int i = 0; i < N * M; i++){
                    int next = flip(cur, i);
                    if (seen[next]) continue;
                    queue.offer(next);
                    seen[next] = true;
                }
            }
            step++;
        }

        return -1;
    }

    private static int flip(int state, int pos){
        int r = pos / M;
        int c = pos % M;
        int[][] dirs = {{0, 0}, {1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] d : dirs){
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr == N || nc < 0 || nc == M) continue;
            state ^= (1 << (nr * M + nc));
        }

        return state;
    }
}
