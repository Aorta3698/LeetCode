class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < land.length; i++)
            for (int j = 0; j < land[0].length; j++)
                if (land[i][j] == 1){
                    int[] bottomRight = new int[2];
                    dfs(land, i, j, bottomRight);
                    ans.add(new int[]{i, j, bottomRight[0], bottomRight[1]});
                }

        return ans.toArray(new int[0][]);
    }

    private void dfs(int[][] land, int r, int c, int[] pos){
        if (r >= land.length || c >= land[0].length || land[r][c] == 0){
            pos[0] = Math.max(r - 1, pos[0]);
            pos[1] = Math.max(c - 1, pos[1]);
            return;
        }

        land[r][c] = 0;
        dfs(land, r + 1, c, pos);
        dfs(land, r, c + 1, pos);
    }
}
