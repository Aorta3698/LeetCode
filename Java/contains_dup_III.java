class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) return false;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            if (set.size() != 0){
                long diff = 0;
                if (nums[i] < set.first()) diff = (long)set.first() - (long)nums[i];
                else diff = (long) nums[i] - (long) set.floor(nums[i]);
                if (diff <= t) return true;

                if (nums[i] > set.last()) diff = (long)nums[i] - (long) set.last();
                else diff = (long) set.ceiling(nums[i]) - (long) nums[i];
                if (diff <= t) return true;
            }

            if (!set.add(nums[i])) return true;
            if (set.size() > k)
                set.remove(nums[i-k]);

        }

        return false;
    }
}
