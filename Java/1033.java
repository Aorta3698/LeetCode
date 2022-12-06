class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] ans = new int[2];
        int[] A = new int[]{a, b, c};
        Arrays.sort(A);
        ans[1] = A[2] - A[0] - 2;
        ans[0] = A[1] - A[0] == 2 || A[2] - A[1] == 2?
            1 : (A[1] - A[0] == 1? 0 : 1) + (A[2] - A[1] == 1? 0 : 1);
        return ans;
    }
}
