class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int i : nums)
            set.add(i);

        for (int i = 1; i < nums.length+1; i++)
            if(!set.contains(i)) ans.add(i);

        return ans;
    }
}
