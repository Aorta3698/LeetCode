class Solution {
    public int findMaxLength(int[] nums) {
        int ans = 0, score = 0;
        Map<Integer, Integer> map = new HashMap<>(Map.of(0, -1));
        for (int i = 0; i < nums.length; i++){
            score += (nums[i] == 0? -1 : 1);
            ans = Math.max(ans, i - map.getOrDefault(score, i));
            map.putIfAbsent(score, i);
        }

        return ans;
    }
}
