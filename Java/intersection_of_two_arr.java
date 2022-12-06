class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> seek = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for (int i : nums1)
            seek.add(i);

        for (int i : nums2)
            if(seek.contains(i))
                ans.add(i);

        int size = ans.size();
        int[] arr = new int[size];
        for (int i : ans)
            arr[--size] = i;

        return arr;
    }
}
