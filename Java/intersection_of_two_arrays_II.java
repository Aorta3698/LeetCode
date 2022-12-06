
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> otherMap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (int i : nums2)
            otherMap.merge(i, 1, Integer::sum);
        for (int i : nums1){
            if (otherMap.getOrDefault(i, 0) > 0) {
                otherMap.merge(i, -1, Integer::sum);
                ans.add(i);
            }
        }

        return ans.stream().mapToInt(o->o).toArray();
    }
}
