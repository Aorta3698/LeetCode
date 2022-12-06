class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++){
            solve(1, i, ans, k, n);
        }
        return ans.stream().mapToInt(o -> o).toArray();
    }

    private void solve(int i, int cur, List<Integer> ans, int k, int n){
        if (i == n){
            ans.add(cur);
            return;
        }

        int last = cur % 10;
        if (last + k <= 9){
            solve(i + 1, 10 * cur + last + k, ans, k, n);
        }
        if (last - k >= 0 && k > 0){
            solve(i + 1, 10 * cur + last - k, ans, k, n);
        }
    }
}
