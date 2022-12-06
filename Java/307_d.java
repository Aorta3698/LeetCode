class Solution {
    public long kSum(int[] nums, int k) {
        long minus = 0, all = 0;
        for (int i = 0; i < nums.length; i++){
            all += Math.max(nums[i], 0);
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        var minheap = new PriorityQueue<long[]>(Comparator.comparingLong(o -> o[0]));
        minheap.offer(new long[]{nums[0], 0});
        while(--k>0){
            long[] top = minheap.poll();
            int i = (int)top[1]++;
            long val = top[0];
            minus = val;
            if (i < nums.length-1){
                top[0] += nums[i+1];
                minheap.offer(new long[]{val - nums[i] + nums[i+1], i+1});
                minheap.offer(top);
            }
        }
        return all - minus;
    }
}
