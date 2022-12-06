class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            if (!set.add(i)) 
                set.remove(i);
        }

        int[] ans = new int[set.size()];
        int idx = 0;
        for (Integer i : set)
            ans[idx++] = i;

        return ans;
    }
}
