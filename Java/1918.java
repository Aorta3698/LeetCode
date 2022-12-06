class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int n = nums.length, lo = 0, hi = (int)1e9;

        while(lo < hi){
            int mid = (hi + lo) >> 1;

            int sum = 0, pre = 0;
            for (int i = 0, j = 0; i < n; i++){
                pre += nums[i];
                while(pre > mid){
                    pre -= nums[j++];
                }
                sum += (i - j + 1);
            }

            if (sum >= k){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }

        return lo;
    }
}

// class Solution {
//     public int kthSmallestSubarraySum(int[] nums, int k) {
//         PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
//         for (int i = 0; i < nums.length; i++){
//             minheap.offer(new int[]{nums[i], i});
//         }

//         while(--k > 0){
//             int[] cur = minheap.poll();
//             if (cur[1] < nums.length - 1){
//                 cur[0] += nums[++cur[1]];
//                 minheap.offer(cur);
//             }
//         }

//         return minheap.peek()[0];
//     }
// }
