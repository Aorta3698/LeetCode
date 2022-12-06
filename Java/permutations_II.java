class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> save = new LinkedList<>();
    HashSet<List<Integer>> set = new HashSet<>();
    boolean[] chosen;
    public List<List<Integer>> permuteUnique(int[] nums) {
        chosen = new boolean[nums.length];

        make(nums);
        return ans;
    }

    private void make(int[] nums){
        if (save.size() == nums.length){
            if (set.add(save))
                ans.add(new ArrayList<>(save));
            return;
        }else{
            for (int i = 0; i < nums.length; i++){
                if (chosen[i])
                    continue;
                else{
                    save.add(nums[i]);
                    chosen[i] = true;
                    make(nums);
                    chosen[i] = false;
                    save.removeLast();
                }
            }
        }
    }
}
