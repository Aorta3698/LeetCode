class Solution {
    public int regionsBySlashes(String[] grid) {
        int[][] mat = new int[grid.length * 3][grid.length * 3];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length(); j++){
                if (grid[i].charAt(j) == '\\')
                    for (int g = 0; g < 3; g++)
                        mat[3 * i + g][3 * j + g] = 1;
                
                if (grid[i].charAt(j) == '/')
                    for (int g = 0; g < 3; g++)
                        mat[3 * i + g][3 * j - g + 2] = 1;
            }
        }

        // for (int[] m : mat)
        //     System.out.println(Arrays.toString(m));
        // System.out.println();

        int ans = 0;
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[0].length; j++)
                if (mat[i][j] == 0){
                    ans++;
                    paint(mat, i, j);
                }

        return ans;
    }

    private void paint(int[][] mat, int r, int c){
        if (r < 0 || r >= mat.length || c < 0 || c >= mat.length || mat[r][c] == 1) return;

        mat[r][c] = 1;
        paint(mat, r + 1, c);
        paint(mat, r - 1, c);
        paint(mat, r, c - 1);
        paint(mat, r, c + 1);
    }
}
