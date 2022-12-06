class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> one = new HashMap<>();
        Map<Integer, Integer> two = new HashMap<>();
        for (int n : nums1){
            one.merge(n, 1, Integer::sum);
        }
        for (int n : nums2){
            two.merge(n, 1, Integer::sum);
        }

        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> a = new HashSet<>();
        for (int n : nums1){
            if (!two.containsKey(n)){
                a.add(n);
            }
        }
        ans.add(new ArrayList<>(a));

        Set<Integer> b = new HashSet<>();
        for (int n : nums2){
            if (!one.containsKey(n)){
                b.add(n);
            }
        }
        ans.add(new ArrayList<>(b));

        return ans;
    }
}
