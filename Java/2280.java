class Solution {
    public int minimumLines(int[][] A) {
        if (A.length == 1)
            return 0;

        Arrays.sort(A, Comparator.comparingInt(o -> o[0]));
        int ans = 1;
        for (int i = 2, st = 0, j = 1; i < A.length; i++){
            int dx = A[i][0] - A[st][0];
            int dy = A[i][1] - A[st][1];
            int ddx = A[j][0] - A[st][0];
            int ddy = A[j][1] - A[st][1];
            if (dx * ddy != dy * ddx){
                st = i - 1;
                j = i;
                ans++;
            }
        }
        return ans;
    }
}
