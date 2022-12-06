class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] ans = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++)
            for (int j = 0; j < image[0].length; j++)
                ans[i][j] = 1 - image[i][image[0].length - 1 - j];

        return ans;
    }
}
