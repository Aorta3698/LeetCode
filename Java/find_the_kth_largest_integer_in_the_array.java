class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Comparator<String> comp = (a, b) -> {
            return a.length() == b.length()? b.compareTo(a) : b.length() - a.length();
        };

        Arrays.sort(nums, comp);
        return nums[k-1];
    }
}
