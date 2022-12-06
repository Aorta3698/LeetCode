class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> store = new ArrayList<>();
        for (int i = 0; i < nums.length; i+=2)
            while(nums[i]-->0) store.add(nums[i+1]);

        return store.stream().mapToInt(o->o).toArray();
    }
}
