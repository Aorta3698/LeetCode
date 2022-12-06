class Solution {
    public int maxSumMinProduct(int[] nums) {
        long[] pre = new long[nums.length + 1];
        int[] hi = new int[nums.length];
        int[] lo = new int[nums.length];
        find(nums, hi, 1);
        find(nums, lo, -1);
        for (int i = 0; i < nums.length; i++){
            pre[i + 1] = pre[i] + nums[i];
        }

        long ans = 0;
        for (int i = 0; i < nums.length; i++){
            ans = Math.max(ans, (pre[hi[i]] - pre[lo[i] + 1]) * nums[i]);
        }

        return (int)(ans % (int)(1e9 + 7));
    }

    private void find(int[] nums, int[] pos, int d){
        int st = d == 1? 0 : nums.length - 1;
        int end = d == 1? nums.length : -1;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = st; i >= 0 && i < nums.length; i += d){
            while(!stack.isEmpty() && nums[i] < nums[stack.peek()]){
                pos[stack.pop()] = i;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            pos[stack.pop()] = end;
        }
    }
}
