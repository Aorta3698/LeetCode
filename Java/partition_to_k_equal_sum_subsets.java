class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        Arrays.sort(nums);
        List<List<Integer>> cand = new ArrayList<>();
        dfs(nums, 0, sum / k, new LinkedList<>(), cand);
        if (cand.size() < k) return false;

        return find(cand, 0, k, new boolean[nums.length]);
    }

    private void dfs(int[] nums, int idx, int target, LinkedList<Integer> tmp, List<List<Integer>> cand){
        if (target == 0){
            cand.add(new ArrayList<>(tmp));
            return;
        }

        if (idx == nums.length || nums[idx] > target) return;

        for (int i = idx; i < nums.length; i++){
            tmp.add(i);
            dfs(nums, i + 1, target - nums[i], tmp, cand);
            tmp.removeLast();
        }
    }

    private boolean find(List<List<Integer>> cand, int idx, int count, boolean[] taken){
        if (count == 0) return true;

        for (int i = idx; i < cand.size(); i++){
            if (check(taken, cand.get(i))){
                for (int s : cand.get(i)) taken[s] = true;
                if (find(cand, i + 1, count - 1, taken)) return true;
                for (int s : cand.get(i)) taken[s] = false;
            }
        }

        return false;
    }

    private static boolean check(boolean[] taken, List<Integer> list){
        for (int idx : list)
            if (taken[idx])
                return false;
        return true;
    }
}
