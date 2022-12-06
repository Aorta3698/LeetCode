class Solution {
    public int slidingPuzzle(int[][] board) {
        Set<Integer> seen = new HashSet<>();
        seen.add(serialize(board));
        Queue<int[][]> queue = new ArrayDeque<>();
        queue.offer(board);
        int target = serialize(new int[][]{{1, 2, 3}, {4, 5, 0}}), ans = 0;
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        while(!queue.isEmpty()){
            for (int i = queue.size(); i > 0; i--){
                int[][] cur = queue.poll();
                if (target == serialize(cur))
                    return ans;
                for (int j = 0; j < 2; j++){
                    for (int k = 0; k < 3; k++){
                        for (int d = 0; d < 4 && cur[j][k] == 0; d++){
                            int nx = j + dx[d];
                            int ny = k + dy[d];
                            if (nx < 0 || ny < 0 || nx == 2 || ny == 3)
                                continue;
                            int[][] next = new int[2][3];
                            for (int p = 0; p < 2; p++){
                                next[p] = cur[p].clone();
                            }
                            next[nx][ny] = 0;
                            next[j][k] = cur[nx][ny];
                            if (seen.add(serialize(next))){
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private int serialize(int[][] board){
        int ans = 0;
        for (int[] b : board){
            for (int n : b){
                ans = (ans << 3) + n;
            }
        }
        return ans;
    }
}
