class Solution {
    public int combinationSum4(int[] nums, int target) {
        AtomicInteger ans = new AtomicInteger(0);
        generate(nums, target, new LinkedList<>(), ans);
        return ans.get();
    }

    private void generate(int[] nums, int target, LinkedList<Integer> tmp,
            AtomicInteger ans){

        if (target <= 0){
            if (target == 0)
                ans.getAndIncrement();
            return;
        }

        for (int i = 0; i < nums.length; i++){
            tmp.add(nums[i]);
            generate(nums, target - nums[i], tmp, ans);
            tmp.removeLast();
        }
    }
}
