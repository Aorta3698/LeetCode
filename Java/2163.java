class Solution {
    public long minimumDifference(int[] nums) {
        long sum = 0, INF = (long)1e11, ans = INF;
        int n = nums.length/3;
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        long[] min = new long[nums.length];
        Arrays.fill(min, INF);
        for (int i = 0; i < nums.length; i++){
            maxheap.offer(nums[i]);
            sum+=nums[i];
            if (maxheap.size()>n){
                sum-=maxheap.poll();
            }
            if (maxheap.size()==n){
                min[i]=sum;
            }
        }
        sum = 0;
        for (int i = nums.length-1; i > 0; --i){
            minheap.offer(nums[i]);
            sum+=nums[i];
            if (minheap.size()>n){
                sum-=minheap.poll();
            }
            if (minheap.size()==n){
                ans = Math.min(ans, min[i-1]-sum);
            }
        }
        return ans;
    }
}
