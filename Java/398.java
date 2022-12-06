class Solution {

    private Map<Integer, List<Integer>> map;
    private Random random;
    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++){
            map.computeIfAbsent(nums[i], o -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        return map.get(target).get(random.nextInt(map.get(target).size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
