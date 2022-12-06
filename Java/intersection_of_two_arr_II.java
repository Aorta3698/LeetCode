class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> otherMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i : nums2)
            otherMap.put(i, otherMap.getOrDefault(i, 0) + 1);
        for (int i : nums1){
            int count = otherMap.getOrDefault(i, 0);
            if (count > 0) {
                otherMap.put(i, otherMap.get(i) - 1);
                ans.add(i);
            }
        }

        return ans.stream().mapToInt(o->o).toArray();
    }
}
