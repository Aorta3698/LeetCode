class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            if (!tree.isEmpty()){
                Integer ceil = tree.ceiling(nums[i]);
                Integer floor = tree.floor(nums[i]);
                if ((ceil != null && (long)ceil - nums[i] <= t)
                    || (floor != null && nums[i] - (long)floor <= t))
                    return true;
            }

            if (!tree.add(nums[i])) return true;
            if (tree.size() > k) tree.remove(nums[i - k]);
        }

        return false;
    }
}
