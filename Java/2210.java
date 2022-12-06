class Solution {
    public int countHillValley(int[] nums) {
        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (Integer n : nums){
            if (!n.equals(deque.peekLast())){
                deque.offerLast(n);
            }
        }

        int prev = deque.poll();
        while (deque.size() > 1){
            int cur = deque.poll();
            if (cur > prev && cur > deque.peekFirst()){
                ans++;
            }
            if (cur < prev && cur < deque.peekFirst()){
                ans++;
            }
            prev = cur;
        }

        return ans;
        // for (int i = 1; i < nums.length - 1; i++){
        //     if (nums[i - 1] < nums[i]){
        //         int j = i;
        //         while(j < nums.length - 1 && nums[j] == nums[j + 1]){
        //             ++j;
        //         }
        //         if (j < nums.length - 1 && nums[i] > nums[j + 1]){
        //             ans++;
        //         }
        //         i = j;
        //     }
        //     if (nums[i - 1] > nums[i]){
        //         int j = i;
        //         while(j < nums.length - 1 && nums[j] == nums[j + 1]){
        //             ++j;
        //         }
        //         if (j < nums.length - 1 && nums[i] < nums[j + 1]){
        //             ans++;
        //         }
        //         i = j;
        //     }
        // }

        // return ans;
    }
}
