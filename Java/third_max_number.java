class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i : nums)
            set.add(i);

        int ans = 0;
        if (set.size() < 3) ans = set.pollLast();
        else {
            set.pollLast();
            set.pollLast();
            ans = set.pollLast();
        }

        return ans;
    }
}
