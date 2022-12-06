class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE, ans = min;
        for (int n : nums){
            if (n % 2 == 1) n *= 2;
            maxheap.offer(n);
            min = Math.min(n, min);
        }
        while(true){
            int cur = maxheap.poll();
            ans = Math.min(cur - min, ans);
            if (cur % 2 == 1) break;
            min = Math.min(cur / 2, min);
            maxheap.offer(cur / 2);
        }
        return ans;
        // PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        // int max = 0, ans = Integer.MAX_VALUE;
        // for (int i = 0; i < nums.length; i++){
        //     int c = nums[i];
        //     while(c % 2 == 0) c >>= 1;
        //     if (nums[i] % 2 == 1) nums[i] *= 2;
        //     minheap.offer(new int[]{i, c});
        //     max = Math.max(c, max);
        // }

        // while(true){
        //     int[] cur = minheap.poll();
        //     ans = Math.min(max - cur[1], ans);
        //     if (cur[1] == nums[cur[0]]) break;
        //     if (Math.abs(max - cur[1]) <= Math.abs(max - 2 * cur[1])) break;
        //     max = Math.max(2 * cur[1], max);
        //     minheap.offer(new int[]{cur[0], 2 * cur[1]});
        // }

        // return ans;
    }
    //31, 15, 41, 27 -> min
    //62, 60, 82, 54 -> max
}
