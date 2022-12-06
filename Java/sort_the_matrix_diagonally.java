class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;

        for (int i = 0; i < r + c - 1; i++){
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int a = Math.max(0, r - i - 1);
            int b = Math.max(0, i - r + 1);
            while(a < r && b < c)
                queue.offer(mat[a++][b++]);
            while(!queue.isEmpty())
                mat[--a][--b] = queue.poll();
        }

        return mat;
    }
}
