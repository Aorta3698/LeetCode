class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) return image;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for (int[] d : dirs){
                int x = d[0] + cell[0];
                int y = d[1] + cell[1];
                if (x < 0 || x >= image.length || y < 0 || y >= image[0].length
                        || image[x][y] != oldColor)
                    continue;
                image[x][y] = newColor;
                queue.offer(new int[]{x, y});
            }
        }

        return image;
    }
}
