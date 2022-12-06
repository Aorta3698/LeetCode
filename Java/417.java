class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights[0].length, m = heights.length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < n; i++){
            mark(0, i, 0, heights, pacific);
            mark(m - 1, i, 0, heights, atlantic);
        }
        for (int i = 0; i < m; i++){
            mark(i, 0, 0, heights, pacific);
            mark(i, n - 1, 0, heights, atlantic);
        }

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (pacific[i][j] && atlantic[i][j]){
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;

    }

    private void mark(int i, int j, int prev, int[][] heights, boolean[][] visited){
        if (i < 0 || i == heights.length || j < 0 || j == heights[0].length || visited[i][j] || prev > heights[i][j])
            return;
        visited[i][j] = true;
        mark(i + 1, j, heights[i][j], heights, visited);
        mark(i - 1, j, heights[i][j], heights, visited);
        mark(i, j - 1, heights[i][j], heights, visited);
        mark(i, j + 1, heights[i][j], heights, visited);
    }
}
