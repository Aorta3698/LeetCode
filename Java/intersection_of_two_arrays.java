class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> a = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> b = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        a.retainAll(b);
        int size = a.size();
        int[] ans = new int[size];
        for (int i : a)
            ans[--size] = i;

        return ans;
    }
}
