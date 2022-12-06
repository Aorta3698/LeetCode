class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        if (low == 0){
            ans.add(0);
        }
        for (int i = 1; i < 10; i++){
            solve(low, high, i, ans);
        }
        Collections.sort(ans);
        return ans;
    }

    private void solve(int lo, int hi, long cur, List<Integer> ans){
        if (cur > hi)
            return;
        if (cur >= lo){
            ans.add((int)cur);
        }
        int d = (int)cur % 10;
        if (d > 0){
            solve(lo, hi, 10 * cur + d - 1, ans);
        }
        if (d < 9){
            solve(lo, hi, 10 * cur + d + 1, ans);
        }
    }
}
