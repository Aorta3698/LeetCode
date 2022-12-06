class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        boolean[] seen = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == key){
                for (int j = Math.max(0, i - k); j <= Math.min(nums.length - 1, i + k); j++){
                    if (!seen[j]){
                        ans.add(j);
                        seen[j] = true;
                    }
                }
            }
        }

        return ans;
    }
}
