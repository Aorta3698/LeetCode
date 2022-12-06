https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/discuss/2086516/Java-or-O(MN)-or-86ms-100-(BFS-%2B-DFS)-or-Explained.
class Solution {
    int m, n;
    public int minimumObstacles(int[][] grid) {
        m = grid.length; n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        for (int i = 0; ; i++){
            for (int j = queue.size(); j > 0; j--){
                int[] p = queue.poll();
                grid[p[0]][p[1]] = 0;
                if (explore(p[0], p[1], grid, queue))
                    return i;
            }
        }
    }

    private boolean explore(int i, int j, int[][] grid, Queue<int[]> queue){
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] < 0)
            return false;
        if (grid[i][j] == 1){
            grid[i][j] = -1;
            queue.add(new int[]{i, j});
            return false;
        }
        if (i+j == n+m-2)
            return true;
        grid[i][j] = -1;
        return explore(i + 1, j, grid, queue)
            || explore(i - 1, j, grid, queue)
            || explore(i, j + 1, grid, queue)
            || explore(i, j - 1, grid, queue);
    }
}
