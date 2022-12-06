https://leetcode.com/problems/n-queens/discuss/2108143/Java-or-Backtracking-or-No-Board
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(0, new boolean[n], new boolean[2*n], new boolean[2*n], new int[n], ans);
        return ans;
    }

    private void backtrack(int m, boolean[] col, boolean[] anti, boolean[] diag,
            int[] selected, List<List<String>> ans){
        int n = selected.length;
        if (m == n){
            List<String> list = new ArrayList<>();
            for (int s : selected){
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[s] = 'Q';
                list.add(String.valueOf(row));
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < n; i++){
            if (col[i] || anti[m+i] || diag[m-i+n])
                continue;
            diag[m-i+n] = anti[m+i] = col[i] = true;
            selected[m] = i;
            backtrack(m+1, col, anti, diag, selected, ans);
            diag[m-i+n] = anti[m+i] = col[i] = false;
        }
    }
}
