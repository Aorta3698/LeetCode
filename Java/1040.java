class Solution {
    public int[] numMovesStonesII(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int[] ans = new int[2];
        ans[1] = Math.max(A[n - 1] - A[1], A[n - 2] - A[0]) - n + 2;
        ans[0] = n;
        for (int i = 0, j = 0; i < n; i++){
            while(A[i] - A[j] + 1 > n){
                ++j;
            }
            int cur = n - (i - j + 1);
            if (A[i] - A[j] + 1 == n - 1 && i - j + 1 == n - 1){
                cur++;
            }
            ans[0] = Math.min(ans[0], cur);
        }
        return ans;
    }
}
