class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length, max = 0;
        List<Integer> ans = new ArrayList<>();
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];
        for (int i = 0; i < pre.length; i++){
            int r = pre[n] - pre[i];
            int l = i - pre[i];
            if (r + l > max){
                ans.clear();
                max = r + l;
            }
            if (max == r + l){
                ans.add(i);
            }
        }

        return ans;
    }
}
