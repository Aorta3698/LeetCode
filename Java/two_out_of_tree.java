class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> ans = new HashSet<>();
        boolean[][] present = new boolean[2][101];
        for (int n : nums1) present[0][n] = true;
        for (int n : nums2){
            present[1][n] = true;
            if (present[0][n]) ans.add(n);
        }
        for (int n : nums3) if (present[0][n] || present[1][n]) ans.add(n);
        return new ArrayList<>(ans);
    }
}
