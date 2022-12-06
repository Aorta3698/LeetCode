https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/discuss/1937384/Monostack-or-Find-the-Next-and-Prev-Greater-Element
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int[] hi = new int[nums.length];
        int[] lo = new int[nums.length];
        locate(nums, hi, 1);
        locate(nums, lo, -1);

        int ans = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < left || nums[i] > right)
                continue;
            ans += (hi[i] - i) * (i - lo[i]);
        }

        return ans;
    }

    private void locate(int[] nums, int[] position, int d){
        Deque<Integer> stack = new ArrayDeque<>();
        int st = d == 1? 0 : nums.length - 1;
        int end = d == 1? nums.length : -1;
        int mode = d == 1? 0 : -1;

        for (int i = st; i >= 0 && i < nums.length; i += d){
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()] + mode){
                position[stack.pop()] = i;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            position[stack.pop()] = end;
        }
    }
}
