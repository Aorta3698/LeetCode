class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new boolean[nums.length], new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int i, int[] nums, boolean[] seen, List<Integer> tmp, List<List<Integer>> ans){
        if (i == nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = 0; j < nums.length; j++){
            if (!seen[j]){
                seen[j]=true;
                tmp.add(nums[j]);
                solve(i+1, nums, seen, tmp, ans);
                tmp.remove(tmp.size()-1);
                seen[j]=false;
            }
        }
    }
}
