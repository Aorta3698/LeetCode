class Solution {
    public int minimumOperations(int[] nums) {
        int[][] even = count(nums, 0);
        int[][] odd  = count(nums, 1);
        if (even[0][0] != odd[0][0]){
            return nums.length - even[0][1] - odd[0][1];
        }else{
            int one = even[0][1] + odd[1][1];
            int two = even[1][1] + odd[0][1];
            return nums.length - Math.max(one, two);
        }
    }

    private int[][] count(int[] nums, int start){
        Map<Integer, Integer> map = new HashMap<>();
        int[][] ans = new int[2][2];

        for (int i = start; i < nums.length; i += 2){
            int c = map.merge(nums[i], 1, Integer::sum);
            if (c > ans[0][1]){
                if (nums[i] != ans[0][0]){
                    ans[1][0] = ans[0][0];
                    ans[1][1] = ans[0][1];
                }
                ans[0][0] = nums[i];
                ans[0][1] = c;
            }else if (c > ans[1][1]){
                ans[1][0] = nums[i];
                ans[1][1] = c;
            }
        }

        return ans;
    }
}
