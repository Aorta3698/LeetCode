class Solution {
    public int minArea(char[][] image, int x, int y) {
        int[] res = dfs(x, y, image);
        return (res[2]-res[0]+1)*(res[1]-res[3]+1);
    }

    private int[] dfs(int i, int j, char[][] image){
        if (i<0||j<0||i==image.length||j==image[0].length||image[i][j]=='0'){
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        }
        image[i][j]='0';
        int[] ans = new int[]{i, j, i, j};
        for (int[] d : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}){
            int[] res = dfs(i+d[0], j+d[1], image);
            ans[0]=Math.min(ans[0], res[0]);
            ans[1]=Math.max(ans[1], res[1]);
            ans[2]=Math.max(ans[2], res[2]);
            ans[3]=Math.min(ans[3], res[3]);
        }
        return ans;
    }

}
