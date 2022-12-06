class FindSumPairs {
    Map<Integer, Integer> one;
    Map<Integer, Integer> two;
    int[] nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        one = new HashMap<>();
        two = new HashMap<>();
        this.nums2 = nums2;

        for (int n : nums1){
            one.merge(n, 1, Integer::sum);
        }
        for (int n : nums2){
            two.merge(n, 1, Integer::sum);
        }
    }

    public void add(int index, int val) {
        two.merge(nums2[index], -1, Integer::sum);
        nums2[index] += val;
        two.merge(nums2[index], 1, Integer::sum);
    }

    public int count(int tot) {
        int ans = 0;
        for (int key : one.keySet()){
            int cur = one.get(key);
            ans += two.getOrDefault(tot - key, 0) * cur;
        }

        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
