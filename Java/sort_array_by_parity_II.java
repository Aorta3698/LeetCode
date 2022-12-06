class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        Deque<Integer> even = new ArrayDeque<>();
        Deque<Integer> odd  = new ArrayDeque<>();
        for (int n : nums){
            if (n % 2 == 0) even.push(n);
            if (n % 2 == 1) odd .push(n);
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = i % 2 == 0? even.pop() : odd.pop();

        return nums;
    }
}
