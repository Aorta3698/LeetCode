class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        check(nums, 0, new LinkedList<>(), ans, new int[nums.length]);

        return ans;
    }

    private void check(int[] nums, int idx, LinkedList<Integer> tmp, List<Integer> ans, int[] curBest){
        if (idx >= nums.length) {
            if (tmp.size() > ans.size()){
                ans.clear();
                ans.addAll(new ArrayList<>(tmp));
            }
            return;
        }

        if (tmp.isEmpty() || curBest[idx] < tmp.size() && nums[idx] % tmp.getLast() == 0){
            curBest[idx] = tmp.size();
            tmp.add(nums[idx]);
            check(nums, idx + 1, tmp, ans, curBest);
            if (ans.size() == nums.length) return;
            tmp.removeLast();
        }

        check(nums, idx + 1, tmp, ans, curBest);
    }
}
