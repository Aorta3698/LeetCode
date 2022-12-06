class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0, r = 0, c = 0, N = matrix.length, M = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        while(true){
            while(valid(matrix, r, c, N, M)){
                ans.add(matrix[r][c]);
                matrix[r][c] = Integer.MIN_VALUE;
                r += dirs[d][0];
                c += dirs[d][1];
            }
            if (ans.size() == N * M) break;
            r -= dirs[d][0];
            c -= dirs[d][1];
            matrix[r][c] = ans.remove(ans.size() - 1);
            d = ++d % 4;
        }

        return ans;
    }

    private static boolean valid(int[][] matrix, int r, int c, int N, int M){
        return r >= 0 && r < N && c >= 0 && c < M && matrix[r][c] != Integer.MIN_VALUE;
    }
}
