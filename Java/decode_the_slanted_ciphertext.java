class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                grid[i][j] = encodedText.charAt(i*cols+j);

        StringBuilder[] sb = new StringBuilder[cols];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuilder();

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (j - i >= 0)
                    sb[j - i].append(grid[i][j]);

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < sb.length; i++)
            ans.append(sb[i]);

        return ans.toString().stripTrailing();
    }
}
