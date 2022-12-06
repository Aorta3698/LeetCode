class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, n+1, k, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int cur, int end, int k, List<Integer> tmp, List<List<Integer>> ans){
        if (cur == end){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (k-tmp.size()<end-cur){
            solve(cur+1, end, k, tmp, ans);
        }
        if (tmp.size()<k){
            tmp.add(cur);
            solve(cur+1, end, k, tmp, ans);
            tmp.remove(tmp.size()-1);
        }
    }
}
