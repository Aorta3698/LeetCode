class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int i = 0, n = nums.length;
        while(i < n){
            int start = nums[i], end = nums[i];
            while(i < n - 1 && end + 1 >= nums[i + 1]) end = nums[++i];
            if (start != end) ans.add(start + "->" + end);
            else ans.add(""+start);
            i++;
        }

        return ans;
    }
}
