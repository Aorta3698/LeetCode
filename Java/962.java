class Solution {
    public int maxWidthRamp(int[] nums) {
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--){
            int prev = list.isEmpty()? -1 : nums[list.get(list.size() - 1)];
            if (prev < nums[i]){
                list.add(i);
            }
        }

        for (int i = 0; i < nums.length; i++){
            int lo = 0, hi = list.size();
            while(lo < hi){
                int mid = (lo + hi) >> 1;
                if (nums[list.get(mid)] >= nums[i])
                    hi = mid;
                else
                    lo = mid + 1;
            }
            ans = Math.max(ans, list.get(lo) - i);
        }

        return ans;
    }
}
