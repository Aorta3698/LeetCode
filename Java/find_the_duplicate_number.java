class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) if (!set.add(i)) return i;
        return -1;
    }
}
