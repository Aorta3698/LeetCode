https://leetcode.com/problems/n-queens-ii/discuss/2111640/Java-or-Backtracking-Concise-solution
class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, new boolean[n], new boolean[2*n], new boolean[2*n]);
    }

    private int backtrack(int m, boolean[] col, boolean[] anti, boolean[] diag){
        int n = col.length, ans = 0;
        if (m == n)
            return 1;
        for (int i = 0; i < n; i++){
            if (!col[i] && !anti[m+i] && !diag[m-i+n]){
                diag[m-i+n] = anti[m+i] = col[i] = true;
                ans += backtrack(m+1, col, anti, diag);
                diag[m-i+n] = anti[m+i] = col[i] = false;
            }
        }
        return ans;
    }
}
