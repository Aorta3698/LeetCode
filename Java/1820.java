class Solution {
    public int maximumInvitations(int[][] grid) {
        int ans = 0;
        int[] match = new int[grid[0].length];
        Arrays.fill(match, -1);

        for (int i = 0; i < grid.length; i++){
            if (dfs(i, grid, new boolean[grid[0].length], match)){
                ++ans;
            }
        }

        return ans;
    }

    private boolean dfs(int boy, int[][] grid, boolean[] askedGirls, int[] match){
        for (int j = 0; j < grid[boy].length; j++){
            if (grid[boy][j] == 0 || askedGirls[j])
                continue;
            askedGirls[j] = true;
            if (match[j] < 0 || dfs(match[j], grid, askedGirls, match)){
                match[j] = boy;
                return true;
            }
        }
        return false;
    }
}
