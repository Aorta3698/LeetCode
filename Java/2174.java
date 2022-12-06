class Solution {
    public int removeOnes(int[][] grid) {
        int sum = 0, ans = 0;
        for (int[] g : grid)
            for (int k : g)
                sum += k;
        return backtrack(grid, sum);
    }

    private int backtrack(int[][] grid, int target){
        if (target == 0) return 0;
        int ans = target;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0) continue;
                Deque<int[]> stack = new ArrayDeque<>();
                int sum = 0;
                for (int w = 0; w < grid[0].length; w++) {
                    if (grid[i][w] == 1){
                        stack.push(new int[]{i, w});
                        grid[i][w] = 0;
                        sum++;
                    }
                }
                for (int w = 0; w < grid.length; w++) {
                    if (grid[w][j] == 1){
                        stack.push(new int[]{w, j});
                        grid[w][j] = 0;
                        sum++;
                    }
                }
                ans = Math.min(ans, backtrack(grid, target - sum));
                while(!stack.isEmpty()){
                    int[] r = stack.pop();
                    grid[r[0]][r[1]] = 1;
                }
            }
        }
        return ans + 1;
    }
}
