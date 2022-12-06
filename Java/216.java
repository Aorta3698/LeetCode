class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, k, n, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int i, int k, int sum, List<Integer> cur, List<List<Integer>> ans){
        if (cur.size() == k || i == 9 || sum <= 0){
            if (sum == 0 && cur.size() == k){
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        solve(i + 1, k, sum, cur, ans);
        cur.add(i + 1);
        solve(i + 1, k, sum - i - 1, cur, ans);
        cur.remove(cur.size() - 1);
    }
}
