class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] gain = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++){
            // rotate leftward -> index is decreasing, only the element jumps from 0 to n -1 gains a point
            // i - x < nums[i] -> i - nums[i] < x -> when min x = i - nums[i] + 1, it starts lose a point.
            gain[(i - nums[i] + n + 1) % n]--;
        }

        int ans = 0, pre = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            pre += gain[i] + (i == 0? 0 : 1);
            if (pre > max){
                max = pre;
                ans = i;
            }
        }

        return ans;
    }
}
